package poi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportOrExportXls {

    public void importXls(HSSFWorkbook hwk){
       //获得第一个表单
       HSSFSheet sheet = hwk.getSheetAt(0);
       //获得一个sheet中合并单元格的数量
        int sheetmergerCount = sheet.getNumMergedRegions();
        //获得一个sheet中所有的合并单元格
       List<CellRangeAddress> cellRangeAddressList =  sheet.getMergedRegions();
       //获取第一个合并单元格
       CellRangeAddress cellRangeAddress = sheet.getMergedRegion(0);
       //总行数
       int count = sheet.getLastRowNum() + 1; //总行数
        System.out.println("数据总行数:" + count);
       for(int i= 1; i < count; i++){
          //获取某一行
          Row row = sheet.getRow(i);
          System.out.print(getCellValue(row.getCell(0)));
          System.out.print(getCellValue(row.getCell(1)));
         /* System.out.print(getCellValue(row.getCell(2)));*/
          if(isMergedRegion(sheet,i,0)){
              int lastRow = getRowNum(sheet,row.getCell(0)).get("lastRow");
              System.out.println("最后一行索引" + lastRow);
              for(; i < lastRow + 1; i++){
                  Row row1 = sheet.getRow(i);
                  System.out.print(getCellValue(row1.getCell(2)));
                  System.out.print(getCellValue(row1.getCell(3)));
                 /* System.out.println(getCellValue(row1.getCell(5)));*/
              }
              i--;
          } else {
              System.out.print(getCellValue(row.getCell(2)));
              System.out.print(getCellValue(row.getCell(3)));
              /*System.out.print(getCellValue(row.getCell(5)));*/
          }
       }
    }

    /**
     * 判断单元格值得类型
     * @param cell
     * @return
     */
    private String getCellValue(Cell cell){
       if (cell == null) return "";
       if(cell.getCellTypeEnum().equals(CellType.STRING)){
           return cell.getStringCellValue();
       } else if (cell.getCellTypeEnum().equals(CellType.BOOLEAN)){
           return String.valueOf(cell.getBooleanCellValue());
       } else if (cell.getCellTypeEnum().equals(CellType.FORMULA)){
           return cell.getCellFormula();
       } else if (cell.getCellTypeEnum().equals(CellType.NUMERIC)){
           return String.valueOf(cell.getNumericCellValue());
       }
       return "";
    }

    /**
     * 判断第row行第column列是否是处于合并单元格的范围内
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private boolean isMergedRegion(Sheet sheet, int row , int column){
        //获取当前表单合并单元数
        int count = sheet.getNumMergedRegions();
        for(int i = 0; i < count; i++){
            //获取第i个合并单元格
            CellRangeAddress cellRangeAddress = sheet.getMergedRegion(i);
            //获取该合并单元格的首末行与首末列
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            //若当前单元格处于合并单元格范围内
            if(row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn){
                return true;
            }

        }
        return false;
    }

    /**
     * 获取属于合并单元格的最后一行与最后一列
     * @param sheet
     * @param cell
     * @return
     */
    private Map<String,Integer> getRowNum(Sheet sheet, Cell cell ){
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        List<CellRangeAddress> cellRangeAddressList = sheet.getMergedRegions();
       for (CellRangeAddress cellRangeAddress:cellRangeAddressList){
           if (cell.getRowIndex() >= cellRangeAddress.getFirstRow() && cell.getRowIndex() <= cellRangeAddress.getLastRow()){
               if (cell.getColumnIndex() >= cellRangeAddress.getFirstColumn() && cell.getColumnIndex() <= cellRangeAddress.getLastColumn()){
                   resultMap.put("lastRow",cellRangeAddress.getLastRow());
                   resultMap.put("lastColumn",cellRangeAddress.getLastColumn());
               }
           }
       }
       return resultMap;
    }
}
