public class YellowSide {
    
    private int[][] cube;
    private final SolveHelper helper;


    public YellowSide(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveYellowSide(int[][] cube) {
        this.cube = cube;
        createYellowSide();
        return cube;
    }

    public void createYellowSide() {
        while (!isYellowSide()) {
            //diagonal side
            if((cube[2][0] == 2 && cube[0][2] == 2) || (cube[0][0] == 2 && cube[2][2] == 2)) {
                if(cube[6][0] == 2 && cube[9][2] == 2) {
                    diagonalCrossFormula();
                }
                else {
                    cube = helper.U(cube);
                }
            }
            //big block
            else if((cube[0][0] == 2 && cube[2][0] == 2) || (cube[2][0] == 2 && cube[2][2] == 2) || (cube[2][2] == 2 && cube[0][2] == 2) || (cube[0][2] == 2 && cube[0][0] == 2)) {
                //T formula
                if(cube[6][0] == 2 && cube[2][2] == 2 && cube [0][2] == 2) {
                    TFormula();
                }
                //U Formula
                else if(cube[6][0] == 2 && cube[6][2] == 2 && cube[0][0] == 2 && cube[0][2] == 2) {
                    UFormula();
                }
                else {
                    cube = helper.U(cube);
                }
            }
            //Corner Dot
            else if(cube[0][0] == 2 || cube[2][0] == 2 || cube[2][2] == 2 || cube[0][2] == 2) {
                if(cube[2][0] ==  2 && cube[6][2] == 2) {
                    Sune();
                }
                else if(cube[6][0] == 2 && cube[2][2] == 2) {
                    AntiSune();
                }
                else {
                    cube = helper.U(cube);
                }
            }
            //No Corners
            else if(cube[0][0] != 2 && cube[2][0] != 2 && cube[2][2] != 2 && cube[0][2] != 2) {
                if(cube[6][0] == 2 && cube[6][2] == 2) {
                    //H situation
                    if(cube[17][0] == 2 && cube[17][2] == 2) {
                        HFormula();
                    }
                    //Pi Situation
                    else if(cube[3][0] == 2 && cube[9][2] == 2) {
                        cube = helper.U(cube);
                        PiFormula();
                    }
                    else {
                        cube = helper.U(cube);
                    }
                }
                else {
                    cube = helper.U(cube);
                }
            }
            else {
                System.out.println("Error");
                System.out.println(TroubleShooter.tempPrint(cube));
                return;
            }
        }
    }


    public void PiFormula() {
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
    }

    public void HFormula() {
        cube = helper.F(cube);
        for(int i = 0; i < 3; i++) {
            cube = helper.R(cube);
            cube = helper.U(cube);
            cube = helper.RPrime(cube);
            cube = helper.UPrime(cube);
        }
        cube = helper.FPrime(cube);
    }

    public void Sune() {
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
    }
    
    public void AntiSune() {
        cube = helper.LPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.L(cube);
        cube = helper.UPrime(cube);
        cube = helper.LPrime(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.L(cube);
    }

    public void UFormula() {
        cube = helper.R(cube);
        cube = helper.R(cube);
        cube = helper.D(cube);
        cube = helper.RPrime(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.DPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
    }

    public void TFormula() {
        cube = helper.X(cube);
        cube = helper.L(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.LPrime(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.XPrime(cube);
    }

    public void diagonalCrossFormula() {
        cube = helper.X(cube);
        cube = helper.RPrime(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.DPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.D(cube);
        cube = helper.XPrime(cube);
    }

    public boolean isYellowSide() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(cube[i][j] != 2) {
                    return false;
                }
            }
        }
        return true;
    }

}
