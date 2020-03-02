public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
    if(first == null) {
        this.first = value;

    } else if(first.getColumn() > value.getColumn()){
        ValueNode tmp = first;
        first = value;
        first.setNextColumn(tmp);
    }else { //after first

            ValueNode current = first;

            while(current.getNextColumn() != null && current.getNextColumn().getColumn() < value.getColumn()){
                current = current.getNextColumn();
            }

            if(current.getNextColumn() == null) { //if last col
                current.setNextColumn(value);
            }else{
                value.setNextColumn(current.getNextColumn());
                current.setNextColumn(value);
            }
        }

    }

    public int get(int position) {
        ValueNode current = first;

        while(current.getNextColumn() != null && current.getColumn() != position){
            current = current.getNextColumn();
        }
        if(current.getNextColumn() == null){
            return 0;
        }else{
            return current.getValue();
        }

    }

}
