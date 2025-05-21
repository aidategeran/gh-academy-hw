class MinStack {
    List <Integer> data;
    List <Integer> min_data;
    
    public MinStack() {
        data = new ArrayList<>();
        min_data = new ArrayList<>();
    }
    
    public void push(int val) {
        data.add(val);
        if (min_data.isEmpty() || val <= min_data.get(min_data.size() - 1)) {
            min_data.add(val);
        } else {
            min_data.add(min_data.get(min_data.size()- 1));
        }
    }
    
    public void pop() {
        data.remove(data.size() - 1);
        min_data.remove(min_data.get(min_data.size() - 1));

    }
    
    public int top() {
        return data.get(data.size() - 1);
    }
    
    public int getMin() {
        return min_data.get(min_data.size() - 1);  
    }

}
