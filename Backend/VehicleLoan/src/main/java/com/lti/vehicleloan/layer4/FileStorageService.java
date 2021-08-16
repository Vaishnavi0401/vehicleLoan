package com.lti.vehicleloan.layer4;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileStorageService {
	
	public void init();
//	public void save(MultipartFile file, Integer userId);
	public Stream<Path> loadAll();
	public void save(MultipartFile file);
	public void deleteAll();
	public Stream<Path> loadBasedOnUserId(String userId);
	public Resource load(String filename);
}
