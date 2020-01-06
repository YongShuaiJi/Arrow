package core.images;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class ScreenShotOnFailure {

	/**
	 * @Attachment allure中表示上传附件
	 * type 说明上传文件的类型
	 * 此方法用于截图并上传到Allure中的附件中，可以在测试失败后查看最后失败的截图。
	 * TestListener(监听器),中的失败情况发生后会调Run方法，Run方法会调用此方法。
	 * **/
	@Attachment(value = "Failure in method {0}", type = "image/png")
    public static byte[] takeScreenShot(String methodName,WebDriver driver) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
