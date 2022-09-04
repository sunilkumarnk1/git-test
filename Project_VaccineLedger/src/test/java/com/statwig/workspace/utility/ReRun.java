package com.statwig.workspace.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRun implements IRetryAnalyzer {
    private int minRetryCnt=0;
    private int max_RetryCnt=2;

    @Override
    public boolean retry(ITestResult result) {

        if(!result.isSuccess()){        //check if test is not succeed
            if(minRetryCnt<max_RetryCnt){       //check if max count is reached
                minRetryCnt++;      //mark test has failed
                result.setStatus(ITestResult.FAILURE);
                return true;        //TELLS testng to rerun  the test
            }else{
                result.setStatus(ITestResult.FAILURE);      //if maxcount reached, test marked has failed
            }
        }else{
            result.setStatus(ITestResult.SUCCESS);      //if test passes , testng marks it has passed
        }
        return false;
    }
}
