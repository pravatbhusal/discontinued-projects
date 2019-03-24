package com {
import fl.motion.*

public class Quadratics { //written for IB Extended Essay May 2018

	private var aCoefficient: Number;
	private var bCoefficient: Number;
	private var cCoefficient: Number;

	public function Quadratics(aCoefficient, bCoefficient, cCoefficient) {
		this.aCoefficient = aCoefficient;
		this.bCoefficient = bCoefficient;
		this.cCoefficient = cCoefficient;
	}
	
	public function getVertex(): String {
		//value of axis of symmetry
		var vertexX:Number = -bCoefficient/(2 * aCoefficient);
		//the y-value is the substitution of y = Ax^2 + Bx + C
		var vertexY:Number = aCoefficient * (vertexX * vertexX) + bCoefficient * (vertexX) + cCoefficient;
		//vertex form is: y = a(x-h)^2 + k, where (h, k) is the vertex of the parabola. 
		return aCoefficient + "(x-" + vertexX + ")^2 +"  + vertexY;
	}

	public function getSquare(): String {
		var bHalf: Number = (bCoefficient / 2);
		var bHalfSqr: Number = bHalf * bHalf;
		var cInverse_bHalfSqr: Number = (cCoefficient * -1) + bHalfSqr;
		//at this point, the equation should look like (x + bHalf) = +- sqrt(cInverse_bHalfSqr);

		//return the value of x as: x = -bHalf +- sqrt(cInverse_bHalfSqr);
		return "x = " + -bHalf + " +-" + Math.sqrt(cInverse_bHalfSqr);
	}

	public function getRoots(): String {
		var rootsArray: Array = BezierSegment.getQuadraticRoots(aCoefficient, bCoefficient, cCoefficient);
		var roots: String = "";
		var root1: String = (rootsArray[0] == undefined) ? "No root" : String(rootsArray[0]);
		var root2: String = (rootsArray[1] == undefined) ? "No root" : String(rootsArray[1]);

		//check if root1 has a root
		if (root1 == "No root") {
			return "Quadratic has no real roots.";
		} else {
			roots += "[" + root1;
		}

		//check if root2 has a root
		if (root2 == "No root") {
			roots += "]";
		} else {
			roots += "," + root2 + "]";
		}

		return roots;
	}

	public function getNormalEquation(aCoefficient, bCoefficient, cCoefficient): String {
		var equation: String = "";

		//a coefficient
		equation += String(aCoefficient) + "x^2";

		//b coefficient
		if (bCoefficient < 0) {
			equation += " " + String(bCoefficient) + "x";
		} else if (bCoefficient > 0) {
			equation += " +" + String(bCoefficient) + "x";
		}

		//c coefficient
		if (cCoefficient < 0) {
			equation += " " + String(cCoefficient);
		} else if (cCoefficient > 0) {
			equation += " +" + String(cCoefficient);
		}

		return equation;
	}
}
}