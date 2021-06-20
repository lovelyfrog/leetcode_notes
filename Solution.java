class ThroneInheritance {

    HashMap<String, List<String>> map = new HashMap<>();
    HashMap<String, Integer> death = new HashMap<>();
    String kingName;
    public ThroneInheritance(String kingName) {

        map.put(kingName, new LinkedList<String>());
        this.kingName = kingName;

    }
    
    public void birth(String parentName, String childName) {
        List<String> childs = map.get(parentName);
        childs.add(childName);
        if (!map.containsKey(childName)) {
            map.put(childName, new LinkedList<String>());    
        }
        // childParent.put(childName, parentName); 
    }
    
    public void death(String name) {
        // String parent = childParent.get(name);
        // List<String> childs = map.get(parent);
        death.put(name, -1);

    }
    
    public List<String> getInheritanceOrder() {
        List<String> currOrder = new LinkedList<>();
        helper(currOrder, this.kingName);
        return currOrder;
    }

    public void helper(List<String> currOrder, String curr) {
        if (!death.containsKey(curr)) {
            currOrder.add(curr);
        }
        List<String> childs = map.get(curr);
        for (int i = 0; i < childs.size(); i++) {
            String child = childs.get(i);
            helper(currOrder, child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */