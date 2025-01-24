class ThroneInheritance {
 Map<String, Boolean> alive;
    Map<String, LinkedList<String>> family;
    String root;

    public ThroneInheritance(String kingName) {
        root = kingName;
        alive = new HashMap<>();
        family = new HashMap<>();
        family.put(kingName, new LinkedList<>());
        alive.put(kingName, true);
    }

    public void birth(String parentName, String childName) {
        family.get(parentName).add(childName);
        family.put(childName, new LinkedList<>());
        alive.put(childName, true);
    }

    public void death(String name) {
        alive.put(name, false);
    }


    public List<String> getInheritanceOrder() {
        List<String> list = new LinkedList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(String root, List<String> list) {
        if (alive.get(root)) {
            list.add(root);
        }

        if (family.get(root) != null) {
            for (String s : family.get(root)) {
                dfs(s, list);
            }
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
