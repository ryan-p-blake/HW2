public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }
    public void setFirst(ValueNode inFirst){
        this.first = inFirst;
    }

    public void setNext(MatrixRow next) {
        next.setFirst(this.first);
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
        if(current == null){
            return 0;
        }

        while(current.getNextColumn() != null && current.getColumn() != position){
            current = current.getNextColumn();
        }
        if(current.getNextColumn() == null && current.getColumn() != position){
            return 0;
        }else{
            return current.getValue();
        }

    }

    public void print(){
        ValueNode current = first;

        while(current != null){
            System.out.printf(" %d ", current.getValue());
            current = current.getNextColumn();
        }
        //fix


    }

}
