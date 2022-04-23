package fr.isika.cda14.efund.entity.common;

import java.util.List;

//@Entity
//@Table(name = "content_tab")
public class ContentTab {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "content_tab_id")
	private List<ContentBlock> contentBlocks;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<ContentBlock> getContentBlocks() {
		return contentBlocks;
	}
	
}
