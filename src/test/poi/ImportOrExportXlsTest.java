package test.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import poi.ImportOrExportXls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * xls格式文件导入导出测试
 */
public class ImportOrExportXlsTest {

    private ImportOrExportXls importOrExportXls = new ImportOrExportXls();


    @Test
    public void importTest(){
        String path = "C:\\Users\\Administrator\\Desktop\\yin.xls";
        try {
            InputStream is = new FileInputStream(path);
            HSSFWorkbook hwk = new HSSFWorkbook(is);
            importOrExportXls.importXls(hwk);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
