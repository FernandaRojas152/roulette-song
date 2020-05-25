import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import customExceptions.SongAlreadyExistsException;
import model.MusicLibrary;

/**
 * @version May 24th 2020
 * @author Fernanda
 * Class MusicLibraryTest
 */

class MusicLibraryTest {
	private MusicLibrary music;;
	
	public void setUpStage1() throws SongAlreadyExistsException {
		music= new MusicLibrary();
		music.addSong("give me love", "/res/songs/give me love.wav");
	}
	
	public void setUpStage2() {
		music= new MusicLibrary();
	}
	
	public void setUpStage3() throws SongAlreadyExistsException {
		music= new MusicLibrary();
		music.addSong("stacy", "/res/songs/stacy.wav");
		music.addSong("tired", "/res/songs/tired.wav");
		music.addSong("comethru", "/res/songs/comethru.wav");
	}
	
	@Test
	void testIsEmpty() {
		setUpStage2();
		assertTrue(music.isEmpty());
	}
	
	@Test
	void testAddSong() throws SongAlreadyExistsException {
		setUpStage1();
		assertEquals("give me love", music.getFirst().getSongName(), "Should be give me love");
	}
	
	/**@Test
	void testWrongAddSong() throws SongAlreadyExistsException {
		setUpStage1();
		try {
			music.addSong("give me love", "/res/songs/give me love.wav");
		}catch(Exception e) {
			e.getMessage();
		}
		
		Assertions.assertThrows(SongAlreadyExistsException.class, () -> music.addSong("give me love", "/res/songs/give me love.wav"), "Should throw an exception");
	}
	*/
	@Test
	void testGetSong() throws SongAlreadyExistsException {
		setUpStage2();
		music.addSong("give me love", "/res/songs/give me love.wav");
		music.addSong("stacy", "/res/songs/stacy.wav");
		music.addSong("tired", "/res/songs/tired.wav");
		music.addSong("comethru", "/res/songs/comethru.wav");
		music.addSong("Disarm You", "/res/songs/Disarm You.wav");
		assertEquals("tired", music.getSong(2).getSongName(), "Should be tired");
	}
	
	@Test
	void testGetSize() throws SongAlreadyExistsException {
		setUpStage3();
		assertEquals(3,music.getSize(), "Should be three");
	}
	
	
	@Test
	void testSearchSong() throws SongAlreadyExistsException {
		setUpStage3();
		assertTrue(music.search("tired", "/res/songs/tired.wav"), "Should be true");
	}
}
