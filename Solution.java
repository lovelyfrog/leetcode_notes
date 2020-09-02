class Solution {
    class Automatation {
        String START = "start";
        String SIGNED = "signed";
        String INTEGER = "integer";
        String HALFDECIMAL = "halfdecimal";
        String FALSE = "false";
        String TRUE = "true";
        String HALFSCIENCE = "halfscience";
        String HALFSIGNEDSCIENCE = "halfsignedscience";
        String DECIMAL = "decimal";
        String SCIENCE = "science";
        String POINT = "point";
        boolean ans = false;
        String state = START;
        HashMap<String, String[]> map;
        public Automatation() {
            map = new HashMap<>();
            map.put(START, new String[]{START, POINT, FALSE, INTEGER, SIGNED, FALSE});
            map.put(POINT, new String[]{FALSE, FALSE, FALSE, DECIMAL, FALSE, FALSE});
            map.put(SIGNED, new String[]{FALSE, POINT, FALSE, INTEGER, FALSE, FALSE});
            map.put(INTEGER, new String[]{TRUE, HALFDECIMAL, HALFSCIENCE, INTEGER, FALSE, FALSE});
            map.put(HALFDECIMAL, new String[]{TRUE, FALSE, HALFSCIENCE, DECIMAL, FALSE, FALSE});
            map.put(FALSE, new String[]{FALSE, FALSE, FALSE, FALSE, FALSE, FALSE});
            map.put(TRUE, new String[]{TRUE, FALSE, FALSE, FALSE, FALSE, FALSE});
            map.put(HALFSCIENCE, new String[]{FALSE, FALSE, FALSE, SCIENCE, HALFSIGNEDSCIENCE, FALSE});
            map.put(HALFSIGNEDSCIENCE, new String[]{FALSE, FALSE, FALSE, SCIENCE, FALSE, FALSE});
            map.put(DECIMAL, new String[]{TRUE, FALSE, HALFSCIENCE, DECIMAL, FALSE, FALSE});
            map.put(SCIENCE, new String[]{TRUE, FALSE, FALSE, SCIENCE, FALSE, FALSE});
        }
        public int getValue(char c) {
            if (c == ' ') return 0;
            if (c == '.') return 1;
            if (c == 'e' || c == 'E') return 2;
            if (c >= '0' && c <= '9') return 3;
            if (c == '+' || c == '-') return 4;
            return 5;
        }
        public void get(String s) {
            for (int i = 0; i < s.length(); i++) {
                int index = getValue(s.charAt(i));
                state = map.get(state)[index];
            }
            if (state == TRUE || state == INTEGER || state == DECIMAL || state == SCIENCE || state == HALFDECIMAL) {
                ans = true;
            } else {
                ans = false;
            }
        } 
    }
    public boolean isNumber(String s) {
        Automatation auto = new Automatation();
        auto.get(s);
        return auto.ans;
    }
}
