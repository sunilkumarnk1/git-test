package com.statwig.workspace.utility;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReTryListner implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod){
        testannotation.setRetryAnalyzer(ReRun.class);
    }
}
