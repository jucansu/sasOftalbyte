package es.surmedid.angiobyte.web.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import es.surmedid.angiobyte.domain.Angio;
import es.surmedid.angiobyte.service.AngioService;
import es.surmedid.angiobyte.web.rest.model.Image;
import es.surmedid.angiobyte.web.rest.model.ImageDefinition;
import es.surmedid.angiobyte.web.rest.model.ImageName;
import es.surmedid.angiobyte.web.rest.util.UtilBase64Image;

/**
 * REST controller for managing Images.
 */
@RestController
@RequestMapping("/api")
public class ImagesResource {

	private final Logger log = LoggerFactory.getLogger(ImagesResource.class);

	// private static final String ENTITY_NAME = "images";
	@Value("${IMAGES_CONTEXT_ROOT}")
	private String IMAGES_CONTEXT_ROOT;

	private final AngioService angioService;

	public ImagesResource(AngioService angioService) {
		this.angioService = angioService;
	}

	public static long getCreationTime(File file) throws IOException {
		Path p = Paths.get(file.getAbsolutePath());
		BasicFileAttributes view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
		FileTime fileTime = view.creationTime();
		// also available view.lastAccessTine and view.lastModifiedTime
		return fileTime.toMillis();
	}

	private List<String> getImagesInDirectory(Long historical) throws IOException {
		log.debug("REST request for a image : {}");

		List<String> results = new ArrayList<String>();

		File[] files = new File(IMAGES_CONTEXT_ROOT + "/" + (historical % 10) + "/").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}

		return results;

	}

	/**
	 * GET /images/:id : get the "id" images.
	 *
	 * @param id
	 *            the id of the images to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the images, or
	 *         with status 404 (Not Found)
	 */
	@GetMapping(value = "/images/name")
	@Timed
	public @ResponseBody ImageName getImageName(@RequestParam("id") String id, @RequestParam("type") String type,
			@RequestParam("date") String date) throws IOException {

		log.debug("REST request for a image name : {}");
		Long historial = null;
		Angio angio = angioService.findByNuhsa(id);
		historial = angio.getHistorial();
		ImageName imageName = new ImageName(new ArrayList<String>());
		List<String> results = getImagesInDirectory(historial);
		List<String> finalResult = new ArrayList<String>();

		List<String> splittedList = new ArrayList<String>();

		switch (type) {
		case "campi":
			type = "Cam";
			break;

		case "topo":
			type = "Top";
			break;

		case "octp":
			type = "Oct";
			break;

		case "otra1":
			type = "OcpT";
			break;

		case "otra2":
			type = "OcpM";
			break;

		case "octa":
			type = "Oca";
			break;

		case "conta":
			type = "Con";
			break;

		case "bio":
			type = "Bio";
			break;

		case "polo":
			type = "SLIT";
			break;

		case "paqui":
			type = "Paq";
			break;

		default:
			type = "ANG";
			break;
		}

		if (!type.equals("ANG")) {
			for (String string : results) {
				splittedList = Arrays.asList(string.split("_"));
				if (splittedList.get(0).equals(String.valueOf(historial)) && splittedList.get(1).equals(type)
						&& splittedList.get(2).equals(String.valueOf(date))) {
					finalResult.add(string);
					imageName.setListNames(finalResult);
				}
			}
		} else {
			for (String string : results) {
				splittedList = Arrays.asList(string.split("_"));
				if (splittedList.get(0).equals(String.valueOf(historial))
						&& (splittedList.get(2).equals("ANG") || splittedList.get(2).equals("RET"))) {
					finalResult.add(string);
					imageName.setListNames(finalResult);
				}
			}
		}

		return imageName;
	}

	/**
	 * GET /images/:id : get the "id" images.
	 *
	 * @param id
	 *            the id of the images to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the images, or
	 *         with status 404 (Not Found)
	 */
	@GetMapping(value = "/images/{id}")
	@Timed
	public @ResponseBody Image getImageWithMediaType(@RequestParam("name") String name, @PathVariable String id)
			throws IOException {
		log.debug("REST request for a image : {}");
		List<String> splittedList = new ArrayList<String>();
		splittedList = Arrays.asList(name.replaceAll(".jpg", "").replaceAll(".JPG", "").split("_"));

		String imagePath = IMAGES_CONTEXT_ROOT + "/" + (Integer.parseInt(splittedList.get(0)) % 10) + "/" + name;
		String imageBase64 = UtilBase64Image.encoder(imagePath);

		if (imageBase64 != null) {
			Image image = null;
			File file = new File(imagePath);
			
			if (splittedList.get(2).equals("ANG") || splittedList.get(2).equals("RET")) {
				image = new Image(name, imageBase64, splittedList.get(0), splittedList.get(2), "", splittedList.get(3),
						"OI", getCreationTime(file));
			} else {
				image = new Image(name, imageBase64, splittedList.get(0), splittedList.get(1), splittedList.get(2),
						splittedList.get(4), splittedList.get(5), getCreationTime(file));
			}
			return image;
		}
		return null;

	}
	
	@PostMapping(value = "/listImages/{id}")
	public @ResponseBody List<Image> getListImages(@RequestBody ImageDefinition names, @PathVariable String id) throws IOException {
		
		List<Image> result = new ArrayList<Image>();
		
			
			for(String name : names.getNames()) {
				List<String> splittedList = new ArrayList<String>();
				splittedList = Arrays.asList(name.replaceAll(".jpg", "").replaceAll(".JPG", "").split("_"));

				String imagePath = IMAGES_CONTEXT_ROOT + "/" + (Integer.parseInt(splittedList.get(0)) % 10) + "/" + name;
				String imageBase64 = UtilBase64Image.encoder(imagePath);

				if (imageBase64 != null) {
					Image image = null;
					File file = new File(imagePath);
					
					if (splittedList.get(2).equals("ANG") || splittedList.get(2).equals("RET")) {
						image = new Image(name, imageBase64, splittedList.get(0), splittedList.get(2), "", splittedList.get(3),
								"OI", getCreationTime(file));
					} else {
						image = new Image(name, imageBase64, splittedList.get(0), splittedList.get(1), splittedList.get(2),
								splittedList.get(4), splittedList.get(5), getCreationTime(file));
					}
					
					result.add(image);
				
				}
				
			}
		
		return result;
	}

}
