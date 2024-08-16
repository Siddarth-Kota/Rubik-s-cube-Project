public class YellowCross {
    
    private int[][] cube;
    private final SolveHelper helper;


    public YellowCross(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveYellowCross(int[][] cube) {
        this.cube = cube;
        createYellowCross();
        return cube;
    }

    public void createYellowCross() {
        while(!isYellowCross()) {
            //horizontal line
            if(cube[1][0] == 2 && cube[1][1] == 2 && cube[1][2] == 2) {
                stageFormula();
            }
            //vertical line
            else if(cube[0][1] == 2 && cube[1][1] == 2 && cube[2][1] == 2) {
                cube = helper.UPrime(cube);
            }
            //top right L
            else if(cube[0][1] == 2 && cube[1][1] == 2 && cube[1][0] == 2) {
                stageFormula();
            }
            //any other L
            else if(validL()) {
                cube = helper.U(cube);
            }
            else {
                stageFormula();
            }
        }
    }

    public void stageFormula() {
        cube = helper.F(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.FPrime(cube);
    }

    public boolean validL() {
        int count = 0;
        if(cube[0][1] == 2) {count++;}
        if(cube[1][0] == 2) {count++;}
        if(cube[2][1] == 2) {count++;}
        if(cube[1][2] == 2) {count++;}
        return count >= 2;
    }

    public boolean isYellowCross() {
        return cube[0][1] == 2 && 
                cube[1][1] == 2 && 
                cube[1][0] == 2 && 
                cube[1][2] == 2 && 
                cube[2][1] == 2;
    }
}
