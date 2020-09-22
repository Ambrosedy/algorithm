package collection;

import java.util.Objects;

/**
 * @author 汐19990223
 */
public class Item implements Comparable<Item>{

    private String description;
    private int partNum;

    public Item(String aDescription,int aPartNum){
        description = aDescription;
        partNum = aPartNum;
    }

    public int getPartNum() {
        return partNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPartNum(int partNum) {
        this.partNum = partNum;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNum=" + partNum +
                '}';
    }

//    @Override
//    public boolean equals(Object o){
//        if(this==o){
//            return true;
//        }
//        if(o==null||getClass()!=o.getClass()){
//            return false;
//        }
//        Item item = (Item)o;
//        return Objects.euqals(description,o.description)&&
//                              ((Item) o).partNum==this.partNum;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return partNum == item.partNum &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNum);
    }

    @Override
    public int compareTo(Item item) {
        int diff = Integer.compare(item.partNum,this.partNum);
        return diff!=0?diff:description.compareTo(item.description);
    }
}
