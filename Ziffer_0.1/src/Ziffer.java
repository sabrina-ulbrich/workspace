public class Ziffer {

            public static void main(String[] args) {

               if(args.length==0)
                  System.out.println(werteZiffernfolgeAus("."));
               else
                  System.out.println(werteZiffernfolgeAus(args[0]));

            }

            private static double werteZiffernfolgeAus(String inZiffernString) {

               double wert = 0.0;
               double genauigkeit = 1.0;
               String woBinIch = "VorKomma";
               boolean fehlerfrei = true;
               int position = 1;

               while(position <= inZiffernString.length() &fehlerfrei) {

                  String zchn = inZiffernString.substring(position-1, position);

                  if(zchn.matches("[0-9]")) {

                     if(woBinIch.equals("NachKomma"))
                        genauigkeit = genauigkeit / 10.0;
                        wert = 10.0*wert + Double.parseDouble(zchn);
                  }
                  else if(zchn.equals(".")  & woBinIch.equals("VorKomma"))
                     woBinIch  = "NachKomma";
                  else
                     fehlerfrei = false;

                  position ++;

               }

               if(!fehlerfrei | inZiffernString.length()==0 | ((woBinIch.equals("NachKomma")&inZiffernString.length()==1)))
                  return -1.0;
               else
                  return wert*genauigkeit;
             }
         }
