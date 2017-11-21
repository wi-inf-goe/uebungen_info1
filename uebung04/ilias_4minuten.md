# Teil 2

Korrekt als `false` oder 'falsch' markierte Ausdrücke/Aussagen

Ausdruck: `(3 < 7) && ((17 + 4) % (12 - 5)) != 0` hat den Wert `false`

**Begründung:**

    (3 < 7) && ((17 + 4) % (12 - 5)) != 0
    ⇒true && (21 % 7) != 0
    ⇒ true && 0 != 0
    ⇒ true && false
    ⇒false

Java Codefragment:

    int x = 1;
    x--;
    if (x = 0)
        System.out.println("Wert: Null");
        
 **Begründung:** x = 0 ist eine Zuweisung mit int Wert, der Java Compiler verlangt hier jedoch boolean Werte. Daher Syntaxfehler.
 

    Ein Gleitkomma-Unterlauf ist ein Laufzeitfehler.

**Begründung:** Von einem Gleitkomma-Unterlauf (engl. underflow) ist die Rede, wenn sehr kleine Gleitkommazahlen nicht mehr dargestellt werden können. Sie nehmen dann 0 an und die eigentliche (sehr kleine) Information geht verloren. Es handelt sich um einen Programmierfehler, wenn dadurch Fehler entstehen, erzeugt aber keinen Laufzeitfehler.

    3e-1 ist kein in Java erlaubter Ausdruck.

**Begründung:** 3e-1 repräsentiert die Gleitkommazahl 0.3 und ist ein erlaubter Java-Ausdruck.

    Der Wertebereich von int ist im Wertebereich von float enthalten.

**Begründung:** Sowohl int als auch float werden intern durch 32-bit dargestellt. Die Anzahl an möglichen Codierungen ist also gleich. Da float zusätzlich noch Dezimalzahlen darstellt, muss es int Zahlen geben, die nicht exakt als float dargestellt werden können

Korrekte Aussagen, die nicht markiert werden sollten.

    Der Dezimalbruch 0.2 hat keine endliche Dualbruchentwicklung.

**Begründung:** 0.2 = 0. 0 0 1 1 0 0 1 1 0 0 1 1 0 0 1 1 0 0 1 1 usw.

    Die Konjunktion wird in Java durch den Operator && realisiert.

**Begründung:** Offensichtlich korrekt.

    int und char sind beides Ganzzahldatentypen.

**Begründung:** Korrekt: int ist offensichtlich ganzzahlig und char hat den Wertebereich 0..65535, ist daher auch ganzzahlig.

# Teil 3

Die Reihenfolge der Elemente im Feld a der Länge N soll umgekehrt werden. Wählen Sie den Code aus, der diese Aufgabe am besten löst:

1

    for (int i = 0; i < N/2; i++) {
      int tmp = a[i];
      a[i] = a[N-i-1];
      a[N-i-1] = tmp;
    }

2

    int[] b = new int[N];
    for (int i = 0; i < N; i++)
      b[i] = a[N-i-1];
    a = b;

3

    for (int i = 0; i < N; i++) {
      int tmp = a[i];
      a[i] = a[N-i-1];
      a[N-i-1] = tmp;
    }

4

    for (int i = 0; i < N/2; i++) {
      int tmp = a[i];
      a[i] = a[N-i];
      a[N-i] = tmp;
    }

 1 löst die Aufgabe, indem alle Elemente "um die Mitte herum rotiert" werden. Das sind maximal n/2 Operationen.
 2 löst die Aufgabe NICHT, denn nach n/2 Tauschoperationen wird nochmal zurückgetauscht und alles steht am alten Platz.
3  löst die Aufgabe, verbraucht aber doppelt soviel Speicher wie nötig.
4  löst die Aufgabe NICHT: bei der ersten Iteration wird auf das nicht existente Element a[N] zugegriffen.

# Teil 4

< Code aus dem Ilias >

### Lösung

    1 2 3 4 5 6 7 1




