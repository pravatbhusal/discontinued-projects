package com {
	
	public class Rates { //written for IB Extended Essay May 2018
		
	private var principalAmount: Number;
	private var nominalRate: Number;
	private var numberOfTimes: Number;
	private var timeAmount: Number;
		
		public function Rates(principalAmount, nominalRate, numberOfTimes, time) {
			this.principalAmount = principalAmount;
			this.nominalRate = nominalRate;
			this.numberOfTimes = numberOfTimes;
			this.timeAmount = time;
		}
		public function getCompounRate():String {
			return "" + principalAmount * Math.pow((1 + nominalRate/numberOfTimes), numberOfTimes * timeAmount);
		}
		public function getSimpleRate():String {
			return "" + principalAmount * nominalRate * timeAmount;
		}
	}
	
}
