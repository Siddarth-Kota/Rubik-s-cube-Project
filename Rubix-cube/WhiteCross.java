public class WhiteCross{
    
    private int[][] cube;
    private final SolveHelper helper;

    public WhiteCross(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveWhiteCross(int[][] cube) {
        this.cube = cube;
        if (!isWhiteCross()) {
            OrientWhiteFace();
            positionWhiteEdges();
            createWhiteCross();
        }
        return cube;
    }

    public void createWhiteCross() {
        while(!isWhiteCross()) {
            if(cube[7][1] == cube[6][1] && cube[2][1] == 1) {
                cube = helper.Y(cube);
            }
            else {
                while(cube[7][1] != cube[8][1] || cube[12][1] != 1) {
                    cube = helper.D(cube);
                }
                cube = helper.F(cube);
                cube = helper.F(cube);
                cube = helper.Y(cube);
            }
    }
}

    public void positionWhiteEdges() {
        while(!isDaisy()) {
            //top side
            if(helper.getEdgeColor(cube, 1,"bottom") == 1) {
                while(cube[12][1] == 1) {
                    cube = helper.D(cube);
                }
                cube = helper.F(cube);
                cube = helper.F(cube);
            }
            //left
            if(helper.getEdgeColor(cube, 4,"right") == 1) {
                while(cube[12][1] == 1) {
                    cube = helper.D(cube);
                }
                cube = helper.FPrime(cube);
            }
            //Front face top
            if(helper.getEdgeColor(cube, 7,"top") == 1) {
                while(cube[12][1] == 1) {
                    cube = helper.D(cube);
                }
                cube = helper.F(cube);
            }
            //Front face bottom
            if(helper.getEdgeColor(cube, 7,"bottom") == 1) {
                while(cube[12][1] == 1) {
                    cube = helper.D(cube);
                }
                cube = helper.F(cube);
            }
            //right
            if(helper.getEdgeColor(cube, 10,"left") == 1) {
                while(cube[12][1] == 1) {
                    cube = helper.D(cube);
                }
                cube = helper.F(cube);
            }
            cube = helper.YPrime(cube);
        }
    }
    //Orients the cube such that the white face is on the top
    public void OrientWhiteFace() {        
        if(cube[4][1] == 1) {
            cube = helper.Z(cube);
        }
        else if(cube[7][1] == 1) {
            cube = helper.X(cube);
        }
        else if(cube[10][1] == 1) {
            cube = helper.ZPrime(cube);
        }
        else if(cube[13][1] == 1) {
            cube = helper.X(cube);
            cube = helper.X(cube);
        }
        else if(cube[16][1] == 1) {
            cube = helper.XPrime(cube);
        }
    }

    public boolean isWhiteCross() {
        OrientWhiteFace();
        return cube[0][1] == 1 && cube[1][1] == 1 && cube[2][1] == 1 && cube[1][0] == 1 && cube[1][2] == 1 && cube[3][1] == cube[4][1] && cube[6][1] == cube[7][1] && cube[9][1] == cube[10][1] && cube[17][1] == cube[16][1];
    }

    public boolean isDaisy() {
        return cube[12][1] == 1 && cube[13][0] == 1 && cube[14][1] == 1 && cube[13][2] == 1 && cube[13][1] == 2;
    }
}
