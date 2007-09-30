package captor.projectsystem.build.mapper;

public class MapperException extends Exception {

    public static final long serialVersionUID = 140;

    private int id;
	private String message;
	
	public MapperException(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public MapperException(MapperException e, String message) {
		this.id = e.getId();
		this.message = message.concat("\n").concat(e.getMessage());
	}

	//-------------------------------------------------------------------------
	
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message The message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	//-------------------------------------------------------------------------

	public static int CANNOT_FIND_TASK = -1;
	
	public static int FUNCTION_IDENT_NAME_ERROR = -2;
	public static int FUNCTION_NAME_ERROR = -3;
	public static int IDENT_EXPECTED_ERROR = -4;
	public static int LEFT_PAR_EXPECTED_ERROR = -5;
	public static int RIGHT_PAR_EXPECTED_ERROR = -6;
	public static int COMMA_EXPECTED_ERROR = -7;
	public static int EOF_EXPECTED_ERROR = -8;
	public static int INVALID_TEMPLATE_PATH = -9;
	public static int CANNOT_CREATE_OUTPUT_DIR = -10;
	public static int XPATH_ERROR = -11;
	
	//-------------------------------------------------------------------------
}
