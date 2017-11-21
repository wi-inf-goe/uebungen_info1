public	class StringToFloat {

		public static void main ( String args [] ) {
			String str = args [0];																				// Kommandozeilenargument = String
			int stringlaenge = str.length();


			for ( int i = 0; i < stringlaenge; i ++){
				System.out.print(str.charAt(i));
			}
				System.out.println();

			if( stringlaenge != 32 ){																				//länge prüfen
				System.out.println(" Fehler: Bitte 32 Zeichen eingeben!");
				System.exit(0);
			}

			for ( int i = 0; i < stringlaenge; i ++){												// Zeichen prüfen
				if( str.charAt(i) != '1' && str.charAt(i) != '0' ){
					System.out.println("Fehler: Bitte Gleitkommazahl binär angeben!");
					System.exit(0);
				}
			}

			String s = str.substring(0,1);									//substrings machen
			String e = str.substring(1,9);
			String f = str.substring(9,32);

			if (s.equals("0")){
				if(e.equals("00000000")){
					if(f.equals("00000000000000000000000")){
				System.out.println("+0");
					}
				}
			}

			if (s.equals("1")){
				if(e.equals("00000000")){
					if(f.equals("00000000000000000000000")){
				System.out.println("-0");
					}
				}
			}

			if (s.equals("0")){
				if(e.equals("11111111")){
					if(f.equals("00000000000000000000000")){
				System.out.println("POSITIVE_INFINITY");
					}
				}
			}

			if (s.equals("1")){
				if(e.equals("11111111")){
					if(f.equals("00000000000000000000000")){
				System.out.println("NEGATIVE_INFINITY");
					}
				}
			}

			boolean normalisiert = false;
			boolean denormalisiert = false;

			if(e.equals("00000000")){
				denormalisiert = true;				// Mantisse beginnt mit Bit 0
				System.out.println("Denormalisiert");
			}
			else{
				normalisiert = true;					// Mantisse beginnt mit Bit 1
				System.out.println("Normalisiert");
			}

			int vorzeichen;																			// Vorzeichen bestimmen
			if(s.equals("1")){
				vorzeichen = 1;
			}
			else{
				vorzeichen = 0;
			}
			System.out.println("Vorzeichen s: "+vorzeichen);

			int exponent = 0;
			for(int i=7; i >= 0; i--){																			//Berechnung des exponenten
					if(Character.getNumericValue(e.charAt(i)) == 1){
						exponent = exponent + (int)(Math.pow(2.0, 7-i));
					}
			}
			System.out.println("Exponent e: "+ exponent +"	verschoben: " +(exponent-127));

			float mantisse=0;																							// Berechnung der Mantisse
			for(int i=0; i<=22; i++){
				if(Character.getNumericValue(f.charAt(i)) == 1){
					mantisse = mantisse + (float) (Math.pow(0.5, i+1));
				}
			}
				System.out.println("Mantisse f: " + mantisse);

				float v = 0;																							// Berechnung der Gleitkommazahl
				if(normalisiert == true && denormalisiert == false){
					v = (float)(Math.pow(-1,vorzeichen)) * (float)(Math.pow(2,exponent-127)) * (1+mantisse);
				}
				if(normalisiert == false && denormalisiert == true){
					v = (float)(Math.pow(-1,vorzeichen)) * (float)(Math.pow(2,-126)) * (mantisse);
				}
				System.out.println("Gleitkommazahl v: " + v);
		}
	}
