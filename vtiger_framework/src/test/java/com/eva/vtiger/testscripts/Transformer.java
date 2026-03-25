package com.eva.vtiger.testscripts;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class Transformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation testAnnotation, Class arg1, Constructor arg2,Method arg3) {

		testAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
	}

}

