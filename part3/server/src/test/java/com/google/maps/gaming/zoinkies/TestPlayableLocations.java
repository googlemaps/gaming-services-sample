/**
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.maps.gaming.zoinkies;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.maps.gaming.zoinkies.models.playablelocations.PLCriteria;
import com.google.maps.gaming.zoinkies.models.playablelocations.PLFieldMask;
import com.google.maps.gaming.zoinkies.models.playablelocations.PLFilter;
import com.google.maps.gaming.zoinkies.models.playablelocations.PLLatLng;
import com.google.maps.gaming.zoinkies.models.playablelocations.PLResponse;
import com.google.maps.gaming.zoinkies.services.PlayableLocationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPlayableLocations {

  @Autowired
  PlayableLocationsService PlayableLocationsService;

  /**
   * This test picks 2 playable locations for each S2 cells overlapping the Lat Lng Rectangle
   * provided as input with Low and High corners.
   * We expect 4 S2Cells impacted for this test with a total of 8 playable locations.
   * @throws Exception
   */
  @Test
  public void TestPlayableLocationsRequest() throws Exception {

    PLLatLng hi = new PLLatLng(37.2797796, -122.02596153);
    PLLatLng lo = new PLLatLng(37.2618133,-122.0485384);

    PLResponse response = PlayableLocationsService.RequestPlayableLocations(lo,hi,GetPLDefaultCriteria());
    assertThat(response).isNotNull();
    assertThat(response.getLocationsPerGameObjectType()).isNotNull();
    assertThat(response.getLocationsPerGameObjectType().size()).isEqualTo(1);
    assertThat(response.getLocationsPerGameObjectType().get("0")).isNotNull();
    assertThat(response.getLocationsPerGameObjectType().get("0").getLocations()).isNotNull();
    assertThat(response.getLocationsPerGameObjectType().get("0").getLocations().length).isEqualTo(14);
  }

  private PLCriteria[] GetPLDefaultCriteria() {
    PLCriteria[] plc = new PLCriteria[1];
    plc[0] = new PLCriteria();
    plc[0].setGame_object_type(0);
    plc[0].setFilter( new PLFilter());
    plc[0].getFilter().setMax_location_count(2);
    plc[0].setFields_to_return( new PLFieldMask());
    plc[0].getFields_to_return().setPaths( new String[]{"snapped_point", "place_id", "types"});
    return plc;
  }

}