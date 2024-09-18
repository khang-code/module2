package com.codegym;

public class Triangle {
    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle(double aSide, double bSide, double cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    public double getaSide() {
        return aSide;
    }

    public void setaSide(double aSide) {
        this.aSide = aSide;
    }

    public double getbSide() {
        return bSide;
    }

    public void setbSide(double bSide) {
        this.bSide = bSide;
    }

    public double getcSide() {
        return cSide;
    }

    public void setcSide(double cSide) {
        this.cSide = cSide;
    }

    public String classifyTriangle() {
        if (aSide <= 0 || bSide <= 0 || cSide <= 0 ||
                aSide + bSide <= cSide || aSide + cSide <= bSide || bSide + cSide <= aSide) {
            return "không phải là tam giác";
        }
        if (aSide == bSide && bSide == cSide) {
            return "tam giác đều";
        }
        if (aSide == bSide || bSide == cSide || cSide == aSide) {
            return "tam giác cân";
        }
        return "tam giác thường";
    }
}
