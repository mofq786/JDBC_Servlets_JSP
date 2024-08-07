package abstraction_example;

public class MainClass {
	public static void main(String[] args)
	{
		WhatsApp app = Helper.helper();
		app.calling();
		app.chatting();
		app.status();
	}
}
