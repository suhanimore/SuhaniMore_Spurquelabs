package genericPackage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class CustomListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("[TestCase --"+result.getName()+" Started]", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("[TestCase -- "+result.getName()+" Successful]", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String failedMethod = result.getName();
		Reporter.log("[TestCase -- "+failedMethod+" has failed and taken Screenshot]", true);
		
		LocalDateTime systemDateTime = LocalDateTime.now();
		String timeStamp = systemDateTime.toString().replaceAll(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ERRORSHOTS_PATH+failedMethod+timeStamp+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("[TestCase --"+result.getName()+" Skipped]", true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("[TestCase --"+result.getName()+" failed with success Percentage]", true);
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("[TestCase --"+result.getName()+" failed with timeout]", true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("<Test -->"+context.getName()+" Started", true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("<Test -->"+context.getName()+" Finished", true);
		
	}

	
}
