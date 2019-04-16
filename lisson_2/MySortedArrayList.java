package lisson_2;

public class MySortedArrayList<Item extends Comparable<Item>> extends MyArrayList<Item> {
    public void insert(Item item) {
        super.insert(item);
        int i = this.size() - 1;
        //1 6 8 9 7
        //1 6 8 7 9
        //1 6 7 8 9
        while (i > 0 && this.get(i).compareTo(this.get(i - 1)) < 0) {
            Item temp = this.get(i);
            this.set(i, this.get(i - 1));
            this.set(i - 1, temp);
            i--;
        }
    }

    public boolean find(Item item) {
        int low = 0;
        int high = this.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //(low + high) / 2
            if (item.compareTo(this.get(mid)) < 0) {
                high = mid - 1;
            }
            else if (item.compareTo(this.get(mid)) > 0) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
