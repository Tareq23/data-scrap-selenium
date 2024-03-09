package com.cochrane.medex;

import java.util.Date;

public class Generic{
	
	
    public String id;
    public String name;
    public String type;
    public String pregnancy_cat;
    public String contraindications;
    public String dosage;
    public String mode_of_action;
    public String indication_details;
    public String interaction;
    public String administration;
    public String side_effects;
    public String precautions;
    public String description;
    public String reconstitution;
    public String duration_of_treatment;
    public String pediatric_uses;
    public String storage_conditions;
    public String overdose_effects;
    public Date created_at;
    public Date updated_at;
    public Date deleted_at;
    public String extra_data;
    public String composition;
    public String status;
    public String slug;
    
    public Generic() {}
    
	public Generic(String id, String name, String type, String pregnancy_cat, String contraindications, String dosage,
			String mode_of_action, String indication_details, String interaction, String administration,
			String side_effects, String precautions, String description, String reconstitution,
			String duration_of_treatment, String pediatric_uses, String storage_conditions, String overdose_effects,
			Date created_at, Date updated_at, Date deleted_at, String extra_data, String composition, String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.pregnancy_cat = pregnancy_cat;
		this.contraindications = contraindications;
		this.dosage = dosage;
		this.mode_of_action = mode_of_action;
		this.indication_details = indication_details;
		this.interaction = interaction;
		this.administration = administration;
		this.side_effects = side_effects;
		this.precautions = precautions;
		this.description = description;
		this.reconstitution = reconstitution;
		this.duration_of_treatment = duration_of_treatment;
		this.pediatric_uses = pediatric_uses;
		this.storage_conditions = storage_conditions;
		this.overdose_effects = overdose_effects;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.extra_data = extra_data;
		this.composition = composition;
		this.status = status;
	}



	public String getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getType() {
		return type;
	}



	public String getPregnancy_cat() {
		return pregnancy_cat;
	}



	public String getContraindications() {
		return contraindications;
	}



	public String getDosage() {
		return dosage;
	}



	public String getMode_of_action() {
		return mode_of_action;
	}



	public String getIndication_details() {
		return indication_details;
	}



	public String getInteraction() {
		return interaction;
	}



	public String getAdministration() {
		return administration;
	}



	public String getSide_effects() {
		return side_effects;
	}



	public String getPrecautions() {
		return precautions;
	}



	public String getDescription() {
		return description;
	}



	public String getReconstitution() {
		return reconstitution;
	}



	public String getDuration_of_treatment() {
		return duration_of_treatment;
	}



	public String getPediatric_uses() {
		return pediatric_uses;
	}



	public String getStorage_conditions() {
		return storage_conditions;
	}



	public String getOverdose_effects() {
		return overdose_effects;
	}



	public Date getCreated_at() {
		return created_at;
	}



	public Date getUpdated_at() {
		return updated_at;
	}



	public Date getDeleted_at() {
		return deleted_at;
	}



	public String getExtra_data() {
		return extra_data;
	}



	public String getComposition() {
		return composition;
	}



	public String getStatus() {
		return status;
	}



	public void setId(String id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void setPregnancy_cat(String pregnancy_cat) {
		this.pregnancy_cat = pregnancy_cat;
	}



	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}



	public void setDosage(String dosage) {
		this.dosage = dosage;
	}



	public void setMode_of_action(String mode_of_action) {
		this.mode_of_action = mode_of_action;
	}



	public void setIndication_details(String indication_details) {
		this.indication_details = indication_details;
	}



	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}



	public void setAdministration(String administration) {
		this.administration = administration;
	}



	public void setSide_effects(String side_effects) {
		this.side_effects = side_effects;
	}



	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setReconstitution(String reconstitution) {
		this.reconstitution = reconstitution;
	}



	public void setDuration_of_treatment(String duration_of_treatment) {
		this.duration_of_treatment = duration_of_treatment;
	}



	public void setPediatric_uses(String pediatric_uses) {
		this.pediatric_uses = pediatric_uses;
	}



	public void setStorage_conditions(String storage_conditions) {
		this.storage_conditions = storage_conditions;
	}



	public void setOverdose_effects(String overdose_effects) {
		this.overdose_effects = overdose_effects;
	}



	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}



	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}



	public void setExtra_data(String extra_data) {
		this.extra_data = extra_data;
	}



	public void setComposition(String composition) {
		this.composition = composition;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "Generic [id=" + id + ", name=" + name + ", type=" + type + ", pregnancy_cat=" + pregnancy_cat
				+ ", contraindications=" + contraindications + ", dosage=" + dosage + ", mode_of_action="
				+ mode_of_action + ", indication_details=" + indication_details + ", interaction=" + interaction
				+ ", administration=" + administration + ", side_effects=" + side_effects + ", precautions="
				+ precautions + ", description=" + description + ", reconstitution=" + reconstitution
				+ ", duration_of_treatment=" + duration_of_treatment + ", pediatric_uses=" + pediatric_uses
				+ ", storage_conditions=" + storage_conditions + ", overdose_effects=" + overdose_effects
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at
				+ ", extra_data=" + extra_data + ", composition=" + composition + ", status=" + status + ", slug="
				+ slug + "]";
	}
	
	
    
    
    
    
}
