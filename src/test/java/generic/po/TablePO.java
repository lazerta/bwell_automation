package generic.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// Page Object for web table
public class TablePO {
    private List<List<WebElement>> table = new ArrayList<>();

    public TablePO(WebElement webTable) {

        buildTable(webTable);
    }

    public WebElement getData(int row, int col) {
        return table.get(row).get(col);
    }

    private void buildTable(WebElement element) {
        element.findElements(By.tagName("tr"))
                .forEach(row -> table.add(row.findElements(By.tagName("td"))));
    }

    public List<String> getColDataList(int col) {
        if (col < 0 || col >= table.get(0).size()) {
            throw new IndexOutOfBoundsException("illegal col");
        }

     return    table.stream().map(row -> row.get(col))
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }


}
