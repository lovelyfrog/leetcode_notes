class Solution {
    public boolean isNumber(String s) {
        State state = State.INITIAL;
        HashMap<State, HashMap<charType, State>> map = new HashMap<>();

        HashMap<charType, State> initialMap = new HashMap<>();
        initialMap.put(charType.NUMBER, State.INTEGER);
        initialMap.put(charType.SIGN, State.SIGN);
        initialMap.put(charType.POINT, State.POINT_NLN);

        HashMap<charType, State> signMap = new HashMap<>();
        signMap.put(charType.NUMBER, State.INTEGER);
        signMap.put(charType.POINT, State.POINT_NLN);

        HashMap<charType, State> point_nlnMap = new HashMap<>();
        point_nlnMap.put(charType.NUMBER, State.DECIMAL);

        HashMap<charType, State> point_lnMap = new HashMap<>();
        point_lnMap.put(charType.NUMBER, State.DECIMAL);
        point_lnMap.put(charType.EXP, State.EXP);

        HashMap<charType, State> integerMap = new HashMap<>();
        integerMap.put(charType.NUMBER, State.INTEGER);
        integerMap.put(charType.EXP, State.EXP);
        integerMap.put(charType.POINT, State.POINT_LN);

        HashMap<charType, State> decimalMap = new HashMap<>();
        decimalMap.put(charType.NUMBER, State.DECIMAL);
        decimalMap.put(charType.EXP, State.EXP);

        HashMap<charType, State> expMap = new HashMap<>();
        expMap.put(charType.SIGN, State.EXP_SIGN);
        expMap.put(charType.NUMBER, State.EXP_NUMBER);

        HashMap<charType, State> exp_signMap = new HashMap<>();
        exp_signMap.put(charType.NUMBER, State.EXP_NUMBER);

        HashMap<charType, State> exp_numberMap = new HashMap<>();
        exp_numberMap.put(charType.NUMBER, State.EXP_NUMBER);

        map.put(State.INITIAL, initialMap);
        map.put(State.SIGN, signMap);
        map.put(State.POINT_NLN, point_nlnMap);
        map.put(State.POINT_LN, point_lnMap);
        map.put(State.INTEGER, integerMap);
        map.put(State.DECIMAL, decimalMap);
        map.put(State.EXP, expMap);
        map.put(State.EXP_SIGN, exp_signMap);
        map.put(State.EXP_NUMBER, exp_numberMap);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charType ct = getCharType(c);
            HashMap<charType, State> currMap = map.get(state);
            if (currMap.containsKey(ct)) {
                state = currMap.get(ct);
            } else {
                return false;
            }
        }
        return state == State.INTEGER || state == State.DECIMAL || state == State.EXP_NUMBER || state == State.POINT_LN;
    }   

    public charType getCharType(char c) {
        if (c == '+' || c == '-') {
            return charType.SIGN;
        } else if (c >= '0' && c <= '9') {
            return charType.NUMBER;
        } else if (c == '.') {
            return charType.POINT;
        } else if (c == 'e' || c == 'E') {
            return charType.EXP;
        } else {
            return charType.INVALID;
        }
    }

    enum charType {
        NUMBER,
        SIGN,
        POINT,
        EXP,
        INVALID;
    }

    enum State {
        INITIAL,
        SIGN,
        POINT_NLN,
        POINT_LN,
        INTEGER,
        DECIMAL,
        EXP,
        EXP_SIGN,
        EXP_NUMBER
    }

}