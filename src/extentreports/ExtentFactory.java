package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String path = "C:\\Users\\NISHANT\\eclipse-workspace\\SeleniumPractice\\reports\\report-demo.html";
		extent = new ExtentReports(path, false);
		extent
			.addSystemInfo("Selenium Version", "3.4.0")
			.addSystemInfo("Platform", "Windows");
		
		return extent;
	}

}
