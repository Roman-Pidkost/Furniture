package ua.com.furniture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import ua.com.furniture.dto.BASE64DecodedMultipartFile;
import ua.com.furniture.entity.Commodity;
import ua.com.furniture.entity.Subcategory;
import ua.com.furniture.repository.CommodityRepository;
import ua.com.furniture.repository.SubcategoryRepository;
import ua.com.furniture.service.CommodityService;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService {
    private static final String PATH_TO_IMG = "/root/furnitureResources/img/";


    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public Commodity save(Commodity commodity) {
        String imageFile = commodity.getImageFile();
        commodity = commodityRepository.saveAndFlush(commodity);
        if (imageFile != null && !imageFile.isEmpty()) {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imageByte = new byte[0];
            try {
                imageByte = decoder.decodeBuffer(imageFile.split(",")[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String expansion = imageFile.split(",")[0].split("/")[1].split(";")[0];
            BASE64DecodedMultipartFile base64DecodedMultipartFile = new BASE64DecodedMultipartFile(imageByte, expansion);
            saveFile(base64DecodedMultipartFile, commodity.getId());
        }
        int subcategoryId = commodity.getSubcategory().getId();
        Subcategory subcategory = subcategoryRepository.findOne(subcategoryId);
        commodity.setSubcategory(subcategory);
        return commodityRepository.saveAndFlush(commodity);
    }

    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    public Commodity findOne(int id) {
        return commodityRepository.findOne(id);
    }

    public void delete(int id) {
        commodityRepository.delete(id);
    }

    private void saveFile(MultipartFile file, int id) {
//        File pathToFolder = new File(CommodityServiceImpl.PATH_TO_IMG);
        File pathToFolder = new File(File.separator + "public" + File.separator);
        createFolder(pathToFolder);
        Commodity commodity = commodityRepository.findOne(id);
        File pathToFile;
        if (commodity.getImage() != null && !commodity.getImage().isEmpty()) {
            pathToFile = new File(pathToFolder + File.separator + commodity.getImage() + file.getOriginalFilename());
            pathToFile.delete();
        }
        String imageName = UUID.randomUUID().toString();
        pathToFile = new File(pathToFolder + File.separator + imageName + file.getOriginalFilename());
        writeFile(pathToFile, file);
        commodity.setImage(imageName + file.getOriginalFilename());
        commodityRepository.save(commodity);
    }

    private void createFolder(File pathToFolder) {
        if (!pathToFolder.exists())
            pathToFolder.mkdirs();
    }

    private void writeFile(File PathToFile, MultipartFile file) {
        try (OutputStream fos = new FileOutputStream(PathToFile); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(file.getBytes(), 0, file.getBytes().length);
            bos.flush();
        } catch (IOException e) {

        }
    }
}
