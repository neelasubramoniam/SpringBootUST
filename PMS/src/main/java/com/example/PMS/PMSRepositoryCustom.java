package com.example.PMS;

import java.util.List;

public interface PMSRepositoryCustom 
{

	List<PMS> findAllByeName(String eName);

}
