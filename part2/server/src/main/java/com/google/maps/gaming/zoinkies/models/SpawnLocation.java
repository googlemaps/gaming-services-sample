package com.google.maps.gaming.zoinkies.models;

import com.google.maps.gaming.zoinkies.models.playablelocations.PLLatLng;

/**
 * A POJO class to keep track of spawn locations details.
 */
public class SpawnLocation {
  /**
   * Location id
   */
  private String id;
  /**
   * Is the location currently active?
   */
  private Boolean active;
  /**
   * Item representing this location: Tower, Minion, etc...
   */
  private String object_type_id;
  /**
   * Is this location respawning?
   */
  private Boolean respawns;
  /**
   * When will the location be active again?
   */
  private String respawn_time;
  /**
   * If the location is locked, how many "keys" needed to activate it?
   * These keys must be owned by the player and will be consumed.
   */
  private int number_of_keys_to_activate;
  /**
   * The type of "key" used to lock this location.
   * Keys can be any item in reference data.
   */
  private String key_type_id;
  /**
   * The Latitude Location of this game location.
   */
  private PLLatLng snappedPoint;

  public SpawnLocation() {}

  public SpawnLocation(String id,
      Boolean active,
      String object_type_id,
      Boolean respawns,
      String respawn_time,
      int number_of_keys_to_activate,
      String key_type_id,
      PLLatLng snappedPoint) {
    this.id = id;
    this.active = active;
    this.object_type_id = object_type_id;
    this.respawns = respawns;
    this.key_type_id = key_type_id;
    this.respawn_time = respawn_time;
    this.number_of_keys_to_activate = number_of_keys_to_activate;
    this.snappedPoint = snappedPoint;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getObject_type_id() {
    return object_type_id;
  }

  public void setObject_type_id(String object_type_id) {
    this.object_type_id = object_type_id;
  }

  public Boolean getRespawns() {
    return respawns;
  }

  public void setRespawns(Boolean respawns) {
    this.respawns = respawns;
  }

  public String getKey_type_id() {
    return key_type_id;
  }

  public void setKey_type_id(String key_type_id) {
    this.key_type_id = key_type_id;
  }

  public int getNumber_of_keys_to_activate() {
    return number_of_keys_to_activate;
  }

  public void setNumber_of_keys_to_activate(int number_of_keys_to_activate) {
    this.number_of_keys_to_activate = number_of_keys_to_activate;
  }

  public String getRespawn_time() {
    return respawn_time;
  }

  public void setRespawn_time(String respawn_time) {
    this.respawn_time = respawn_time;
  }

  public PLLatLng getSnappedPoint() {
    return snappedPoint;
  }

  public void setSnappedPoint(
      PLLatLng snappedPoint) {
    this.snappedPoint = snappedPoint;
  }
}
