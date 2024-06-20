package day11.step2;

public class Category {
    private int categoryCode;
    private String categoryName;
    private static int count = 1;

    public Category( String categoryName) {
        this.categoryCode = count;
        this.categoryName = categoryName;
        count++;

    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
