package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Sticker;

public interface StickerDAO {

	public List<Sticker> getStickerList();

	public void saveSticker(Sticker sticker);

	public Sticker getStickerbyId(Integer id);

	public Sticker deleteStickerById(int id);
	
	
}
