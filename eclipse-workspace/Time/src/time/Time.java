package time;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modfied by Liz Dancy
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2021
 */
public class Time
{
	public static void main(String[] args) 
	{
		// added for ICE6 preparation
		int totalSeconds = getTotalSeconds("10:10:10");
		System.out.println("Github: Total Seconds = " + totalSeconds);
	}

	// code for milliseconds format hh:mm:ss:ml
	/**
	 * public static void main(String[] args) {
	 * 
	 * 
	 * try {
	 * 
	 * String time = JOptionPane.showInputDialog(null, "Enter a time in the format
	 * hh:mm:ss:mls", "Enter Time", JOptionPane.QUESTION_MESSAGE);
	 * 
	 * int totalMilliseconds = getTotalMilliseconds(time);
	 * JOptionPane.showMessageDialog(null, totalMilliseconds, "Total Milliseconds",
	 * JOptionPane.INFORMATION_MESSAGE); } catch(StringIndexOutOfBoundsException e)
	 * { JOptionPane.showMessageDialog(null, "You entered the time in the wrong
	 * format.\n" + "Please enter the time in the form hh:mm:ss:mls", "Invalid
	 * Time", JOptionPane.ERROR_MESSAGE); } catch(NumberFormatException e) {
	 * JOptionPane.showMessageDialog(null, "You entered an invalid time.\nPlease
	 * enter numbers seperated using the format hh:mm:ss:mls", "Invalid Time",
	 * JOptionPane.ERROR_MESSAGE); } catch(Exception e) { System.out.println("An
	 * unexpected Exception occurred"); } }
	 * 
	 **/

	public static int getTotalSeconds(String time)throws NumberFormatException, StringIndexOutOfBoundsException {
		
		int hours = getTotalHours(time);
		//we will eventually multiply the hours by 3600 + the minutes by 60 + the seconds
		int minutes = getTotalMinutes (time);
		int seconds = getSeconds(time);
		return hours * 3600 + minutes * 60 + seconds;
	}
	
	public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException 
	{
		
		return Integer.parseInt(time.substring(6,8));
	}

	public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		return Integer.parseInt(time.substring(3,5));
	}

	public static int getTotalHours(String time)throws NumberFormatException, StringIndexOutOfBoundsException
	{
		return Integer.parseInt(time.substring(0,2));
	}
	
	public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		return Integer.parseInt(time.substring(9, 12));
	}

	public static int getTotalMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		
		if (time.length() != 12) {
			throw new NumberFormatException("format is incorrect for getting milliseconds");
		}
		int seconds = getTotalSeconds(time);
		int milliseconds = getMilliseconds(time);
		return seconds * 1000 + milliseconds;

	}

}



