package com.accp.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Project {
    private Integer id;

    private String projectname;

    private String context;

    private Double price;

    private String type;

    private String ids;

    private String ids1;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;
    
    private MultipartFile [] file;
 
    private List<Project> mlist;
    
    
	public List<Project> getMlist() {
		return mlist;
	}

	public void setMlist(List<Project> mlist) {
		this.mlist = mlist;
	}

	public List<Employee> getEmlist() {
		return emlist;
	}

	public void setEmlist(List<Employee> emlist) {
		this.emlist = emlist;
	}

	public List<Field> getFlist() {
		return flist;
	}

	public void setFlist(List<Field> flist) {
		this.flist = flist;
	}

	private List<Employee> emlist;
    
    private List<Field> flist;
    
    private List<Projectimg> proimglist;
    
    

    public List<Projectimg> getProimglist() {
		return proimglist;
	}

	public void setProimglist(List<Projectimg> proimglist) {
		this.proimglist = proimglist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getIds1() {
        return ids1;
    }

    public void setIds1(String ids1) {
        this.ids1 = ids1;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4;
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5;
    }

	public MultipartFile [] getFile() {
		return file;
	}

	public void setFile(MultipartFile [] file) {
		this.file = file;
	}
}