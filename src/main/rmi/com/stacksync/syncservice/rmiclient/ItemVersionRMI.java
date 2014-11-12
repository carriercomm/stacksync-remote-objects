package com.stacksync.syncservice.rmiclient;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ItemVersionRMI {

	private Long id;
	private ItemRMI item;
	private DeviceRMI device;
	private Long version;
	private Date committedAt;
	private Date modifiedAt;
	private Long checksum;
	private String status;
	private Long size;
	private List<ChunkRMI> chunks;

	public ItemVersionRMI() {
		this.id = null;
	}

	public ItemVersionRMI(Long id, ItemRMI item, DeviceRMI device, Long version, Date committedAt,
			Date modifiedAt, Long checksum, String status, Long size) {
		this.id = id;
		this.item = item;
		this.device = device;
		this.version = version;
		this.committedAt = committedAt;
		this.modifiedAt = modifiedAt;
		this.checksum = checksum;
		this.status = status;
		this.size = size;
	}
	
	public ItemVersionRMI(ItemMetadataRMI metadata) {
		this.id = metadata.getVersion();
		this.item = new ItemRMI(metadata.getId());
		this.device = new DeviceRMI(metadata.getDeviceId());
		this.version = metadata.getVersion();
		this.modifiedAt = metadata.getModifiedAt();
		this.checksum = metadata.getChecksum();
		this.status = metadata.getStatus();
		this.size = metadata.getSize();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemRMI getItem() {
		return item;
	}

	public void setItem(ItemRMI item) {
		this.item = item;
	}

	public DeviceRMI getDevice() {
		return device;
	}

	public void setDevice(DeviceRMI device) {
		this.device = device;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Long getChecksum() {
		return checksum;
	}

	public void setChecksum(Long checksum) {
		this.checksum = checksum;
	}

	public Date getCommittedAt() {
		return committedAt;
	}

	public void setCommittedAt(Date committedAt) {
		this.committedAt = committedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public List<ChunkRMI> getChunks() {
		return chunks;
	}

	public void setChunks(List<ChunkRMI> chunks) {
		this.chunks = chunks;
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		String format = "ItemVersion[id=%s, itemId=%s, version=%s, chunks=%s, deviceId=%s, modifiedAt=%s, "
				+ "committedAt=%s, checksum=%s, status=%s, "
				+ "size=%s]";

		Long itemId = null;
		if (item != null) {
			itemId = item.getId();
		}

		Integer chunksSize = null;
		if (chunks != null) {
			chunksSize = chunks.size();
		}

		UUID deviceId = null;
		if (device != null) {
			deviceId = device.getId();
		}

		String result = String.format(format, id, itemId, version, chunksSize, deviceId, modifiedAt,
				committedAt, checksum, status, size);

		return result;
	}
}
