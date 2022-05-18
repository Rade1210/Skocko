package p1;

import javax.swing.JLabel;

public class Slicice extends JLabel{ //svaka slicica ima svoje i, j kordinate, pamti za sebe na kom se mestu u matrici nalaze

	int i=0,j=0;
	
	boolean isLast()
	{
		if (j==5)
			return true;
		else
			return false;
	}
	int symbol=-1; //default vrednost
	boolean isChecked=false;
}
