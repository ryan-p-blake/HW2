public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {

        if(first == null) {
            this.first = value;

        } else if(first.getRow() > value.getRow()){
            ValueNode tmp = first;
            first = value;
            first.setNextRow(tmp);
        }else { //after first

            ValueNode current = first;

            while(current.getNextRow() != null && current.getNextRow().getRow() < value.getRow()){
                current = current.getNextRow();
            }

            if(current.getNextRow() == null) { //if last row
                current.setNextRow(value);
            }else{
                value.setNextRow(current.getNextRow());
                current.setNextRow(value);
            }
        }

    }


    public int get(int position) {
        ValueNode current = first;

        while(current.getNextRow() != null && current.getRow() != position){
            current = current.getNextRow();
        }
        if(current.getNextRow() == null){
            return 0;
        }else{
            return current.getValue();
        }

    }

}
