package com.company.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * Created by Yevgen on 06.01.2016.
 */
public class SelfDescribingObject {
    public static final String METHOD_IS_NOT_PRESENTED_IN_CLASS_PATTERN = "Method <{0}> is not presented in class <{1}>";
    public static final String FIELD_IS_NOT_PRESENTED_IN_CLASS_PATTERN = "Field <{0}> is not presented in class <{1}>";
    public static final String ACCESS_DENIED_TO_THE_FIELD_IN_CLASS_PATTERN = "Access denied to the field <{0}> in class <{1}>";
    public static final String ACCESS_DENIED_TO_THE_METHOD_IN_CLASS_PATTERN = "Access denied to the method <{0}> in class <{1}>";

    public static final String GET_PREFIX = "get";
    public static final String SET_PREFIX = "set";

    public String[] getPublicMethodNameList(String methodPrefix) {
        Method method[] = this.getClass().getMethods();
        ArrayList<String> nameArrayList = new ArrayList<String>();

        boolean notPrefixCheck = (methodPrefix != null) || methodPrefix.isEmpty();

        for (int i = 0; i < method.length; i++) {
            String name = method[i].getName();
            if (notPrefixCheck || name.indexOf(methodPrefix) == 0)
                nameArrayList.add(name);
        }

        String[] methodNameList = new String[nameArrayList.size()];
        nameArrayList.toArray(methodNameList);

        return methodNameList;
    }

    public String[] getPublicFieldNameList() {
        Field field[] = this.getClass().getFields();
        ArrayList<String> nameArrayList = new ArrayList<String>();

        for (int i = 0; i < field.length; i++) {
            nameArrayList.add(field[i].getName());
        }

        String[] methodNameList = new String[nameArrayList.size()];
        nameArrayList.toArray(methodNameList);

        return methodNameList;
    }

    public String[] getGettersNameList() {
        return getPublicMethodNameList(GET_PREFIX);
    }

    public String[] getSettersNameList() {
        return getPublicMethodNameList(SET_PREFIX);
    }

    public String checkWhetherFieldIsPresented(String fieldName, boolean onlyPublic) {
        Class cls = this.getClass();

        String errorMessage = "";
        try {
            // Just check if field "fieldName" presents
            if (onlyPublic)
                cls.getField(fieldName);
            else
                cls.getDeclaredField(fieldName);
        } catch (SecurityException e) {
            errorMessage = MessageFormat.format(ACCESS_DENIED_TO_THE_FIELD_IN_CLASS_PATTERN, fieldName, cls.getName());
        } catch (NoSuchFieldException e) {
            errorMessage = MessageFormat.format(FIELD_IS_NOT_PRESENTED_IN_CLASS_PATTERN, fieldName, cls.getName());
        }

        return errorMessage;
    }

    public String checkWhetherPublicFieldIsPresented(String fieldName) {
        return checkWhetherFieldIsPresented(fieldName, true);
    }

    public String checkWhetherMethodWithoutArgumentsIsPresented(String methodName, boolean onlyPublic) {
        Class cls = this.getClass();

        String errorMessage = "";
        try {
            // Just check if field "methodName" presents
            if (onlyPublic)
                cls.getMethod(methodName, null);
            else
                cls.getDeclaredMethod(methodName, null);
        } catch (SecurityException e) {
            errorMessage = MessageFormat.format(ACCESS_DENIED_TO_THE_METHOD_IN_CLASS_PATTERN, methodName, cls.getName());
        } catch (NoSuchMethodException e) {
            errorMessage = MessageFormat.format(METHOD_IS_NOT_PRESENTED_IN_CLASS_PATTERN, methodName, cls.getName());
        }

        return errorMessage;
    }

    public String checkWhetherPublicMethodWithoutArgumentsIsPresented(String methodName) {
        return checkWhetherMethodWithoutArgumentsIsPresented(methodName, true);
    }

    public ObjectProperty checkProperty(String propertyName) {
        int index = -1;

        // Firstly think that a property is a field
        ObjectProperty objectProperty = new ObjectProperty(propertyName, ObjectProperty.PropertyType.field, propertyName);

        // Firstly - check if this "propertyName" is presented as a pubic field
        String errorMessage = checkWhetherPublicFieldIsPresented(propertyName);
        if (!errorMessage.isEmpty()) {
            //  Try to find a field without case sensitive
            String[] fieldNameList = getPublicFieldNameList();
            index = Utils.getIndexInStringArray(fieldNameList, propertyName, true);
            if (index != -1) {
                objectProperty.setRealPropertyName(fieldNameList[index]);
                errorMessage = "";
            }

            // Need to find method?
            if (!errorMessage.isEmpty()) {
                objectProperty.setPropertyType(ObjectProperty.PropertyType.method);
                String nextErrorMessage = checkWhetherPublicMethodWithoutArgumentsIsPresented(propertyName);
                // Need to find Getter?
                if (nextErrorMessage.isEmpty()) {
                    errorMessage = "";
                    }
                else {
                    // Let's try to find suitable getter
                    String[] gettersNameList = getGettersNameList();
                    index = Utils.getIndexInStringArray(gettersNameList, propertyName, true);
                    if (index == -1) {
                        // Construct "synthetic" getter name
                        propertyName = GET_PREFIX + propertyName;
                        // Find "synthetic" getter
                        index = Utils.getIndexInStringArray(gettersNameList, propertyName, true);
                    }
                    if (index != -1) {
                        objectProperty.setRealPropertyName(gettersNameList[index]);
                        errorMessage = "";
                    }
                }

                if (!errorMessage.isEmpty()) {
                    errorMessage = errorMessage + "\n" + nextErrorMessage;
                }
            }
        }

        // Fix "final" error message
        objectProperty.setErrorMessage(errorMessage);

        return objectProperty;
    }
}
