/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sidney.dbsyncserver.tserializ.dsp;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TDbSync_Dsp_Sina_Ad_Space implements org.apache.thrift.TBase<TDbSync_Dsp_Sina_Ad_Space, TDbSync_Dsp_Sina_Ad_Space._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Sina_Ad_Space> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Sina_Ad_Space");

  private static final org.apache.thrift.protocol.TField SINA_AD_SPACE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sinaAdSpaceId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField AD_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("adSize", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CATEGORY_FIELD_DESC = new org.apache.thrift.protocol.TField("category", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SUB_CATEGORY_FIELD_DESC = new org.apache.thrift.protocol.TField("subCategory", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField SOURCE_FIELD_DESC = new org.apache.thrift.protocol.TField("source", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PAGE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("pageUrl", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField MEDIA_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("mediaIds", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)8);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Sina_Ad_SpaceStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Sina_Ad_SpaceTupleSchemeFactory());
  }

  public String sinaAdSpaceId; // required
  public String adSize; // required
  public String category; // required
  public String subCategory; // required
  public String source; // required
  public String pageUrl; // required
  public String mediaIds; // required
  public int Status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SINA_AD_SPACE_ID((short)1, "sinaAdSpaceId"),
    AD_SIZE((short)2, "adSize"),
    CATEGORY((short)3, "category"),
    SUB_CATEGORY((short)4, "subCategory"),
    SOURCE((short)5, "source"),
    PAGE_URL((short)6, "pageUrl"),
    MEDIA_IDS((short)7, "mediaIds"),
    STATUS((short)8, "Status"),
    LAST_CHANGED((short)9, "lastChanged");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SINA_AD_SPACE_ID
          return SINA_AD_SPACE_ID;
        case 2: // AD_SIZE
          return AD_SIZE;
        case 3: // CATEGORY
          return CATEGORY;
        case 4: // SUB_CATEGORY
          return SUB_CATEGORY;
        case 5: // SOURCE
          return SOURCE;
        case 6: // PAGE_URL
          return PAGE_URL;
        case 7: // MEDIA_IDS
          return MEDIA_IDS;
        case 8: // STATUS
          return STATUS;
        case 9: // LAST_CHANGED
          return LAST_CHANGED;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __STATUS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SINA_AD_SPACE_ID, new org.apache.thrift.meta_data.FieldMetaData("sinaAdSpaceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AD_SIZE, new org.apache.thrift.meta_data.FieldMetaData("adSize", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CATEGORY, new org.apache.thrift.meta_data.FieldMetaData("category", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SUB_CATEGORY, new org.apache.thrift.meta_data.FieldMetaData("subCategory", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SOURCE, new org.apache.thrift.meta_data.FieldMetaData("source", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PAGE_URL, new org.apache.thrift.meta_data.FieldMetaData("pageUrl", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MEDIA_IDS, new org.apache.thrift.meta_data.FieldMetaData("mediaIds", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Sina_Ad_Space.class, metaDataMap);
  }

  public TDbSync_Dsp_Sina_Ad_Space() {
  }

  public TDbSync_Dsp_Sina_Ad_Space(
    String sinaAdSpaceId,
    String adSize,
    String category,
    String subCategory,
    String source,
    String pageUrl,
    String mediaIds,
    int Status,
    String lastChanged)
  {
    this();
    this.sinaAdSpaceId = sinaAdSpaceId;
    this.adSize = adSize;
    this.category = category;
    this.subCategory = subCategory;
    this.source = source;
    this.pageUrl = pageUrl;
    this.mediaIds = mediaIds;
    this.Status = Status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Sina_Ad_Space(TDbSync_Dsp_Sina_Ad_Space other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSinaAdSpaceId()) {
      this.sinaAdSpaceId = other.sinaAdSpaceId;
    }
    if (other.isSetAdSize()) {
      this.adSize = other.adSize;
    }
    if (other.isSetCategory()) {
      this.category = other.category;
    }
    if (other.isSetSubCategory()) {
      this.subCategory = other.subCategory;
    }
    if (other.isSetSource()) {
      this.source = other.source;
    }
    if (other.isSetPageUrl()) {
      this.pageUrl = other.pageUrl;
    }
    if (other.isSetMediaIds()) {
      this.mediaIds = other.mediaIds;
    }
    this.Status = other.Status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_Dsp_Sina_Ad_Space deepCopy() {
    return new TDbSync_Dsp_Sina_Ad_Space(this);
  }

  @Override
  public void clear() {
    this.sinaAdSpaceId = null;
    this.adSize = null;
    this.category = null;
    this.subCategory = null;
    this.source = null;
    this.pageUrl = null;
    this.mediaIds = null;
    setStatusIsSet(false);
    this.Status = 0;
    this.lastChanged = null;
  }

  public String getSinaAdSpaceId() {
    return this.sinaAdSpaceId;
  }

  public TDbSync_Dsp_Sina_Ad_Space setSinaAdSpaceId(String sinaAdSpaceId) {
    this.sinaAdSpaceId = sinaAdSpaceId;
    return this;
  }

  public void unsetSinaAdSpaceId() {
    this.sinaAdSpaceId = null;
  }

  /** Returns true if field sinaAdSpaceId is set (has been assigned a value) and false otherwise */
  public boolean isSetSinaAdSpaceId() {
    return this.sinaAdSpaceId != null;
  }

  public void setSinaAdSpaceIdIsSet(boolean value) {
    if (!value) {
      this.sinaAdSpaceId = null;
    }
  }

  public String getAdSize() {
    return this.adSize;
  }

  public TDbSync_Dsp_Sina_Ad_Space setAdSize(String adSize) {
    this.adSize = adSize;
    return this;
  }

  public void unsetAdSize() {
    this.adSize = null;
  }

  /** Returns true if field adSize is set (has been assigned a value) and false otherwise */
  public boolean isSetAdSize() {
    return this.adSize != null;
  }

  public void setAdSizeIsSet(boolean value) {
    if (!value) {
      this.adSize = null;
    }
  }

  public String getCategory() {
    return this.category;
  }

  public TDbSync_Dsp_Sina_Ad_Space setCategory(String category) {
    this.category = category;
    return this;
  }

  public void unsetCategory() {
    this.category = null;
  }

  /** Returns true if field category is set (has been assigned a value) and false otherwise */
  public boolean isSetCategory() {
    return this.category != null;
  }

  public void setCategoryIsSet(boolean value) {
    if (!value) {
      this.category = null;
    }
  }

  public String getSubCategory() {
    return this.subCategory;
  }

  public TDbSync_Dsp_Sina_Ad_Space setSubCategory(String subCategory) {
    this.subCategory = subCategory;
    return this;
  }

  public void unsetSubCategory() {
    this.subCategory = null;
  }

  /** Returns true if field subCategory is set (has been assigned a value) and false otherwise */
  public boolean isSetSubCategory() {
    return this.subCategory != null;
  }

  public void setSubCategoryIsSet(boolean value) {
    if (!value) {
      this.subCategory = null;
    }
  }

  public String getSource() {
    return this.source;
  }

  public TDbSync_Dsp_Sina_Ad_Space setSource(String source) {
    this.source = source;
    return this;
  }

  public void unsetSource() {
    this.source = null;
  }

  /** Returns true if field source is set (has been assigned a value) and false otherwise */
  public boolean isSetSource() {
    return this.source != null;
  }

  public void setSourceIsSet(boolean value) {
    if (!value) {
      this.source = null;
    }
  }

  public String getPageUrl() {
    return this.pageUrl;
  }

  public TDbSync_Dsp_Sina_Ad_Space setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
    return this;
  }

  public void unsetPageUrl() {
    this.pageUrl = null;
  }

  /** Returns true if field pageUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetPageUrl() {
    return this.pageUrl != null;
  }

  public void setPageUrlIsSet(boolean value) {
    if (!value) {
      this.pageUrl = null;
    }
  }

  public String getMediaIds() {
    return this.mediaIds;
  }

  public TDbSync_Dsp_Sina_Ad_Space setMediaIds(String mediaIds) {
    this.mediaIds = mediaIds;
    return this;
  }

  public void unsetMediaIds() {
    this.mediaIds = null;
  }

  /** Returns true if field mediaIds is set (has been assigned a value) and false otherwise */
  public boolean isSetMediaIds() {
    return this.mediaIds != null;
  }

  public void setMediaIdsIsSet(boolean value) {
    if (!value) {
      this.mediaIds = null;
    }
  }

  public int getStatus() {
    return this.Status;
  }

  public TDbSync_Dsp_Sina_Ad_Space setStatus(int Status) {
    this.Status = Status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field Status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public String getLastChanged() {
    return this.lastChanged;
  }

  public TDbSync_Dsp_Sina_Ad_Space setLastChanged(String lastChanged) {
    this.lastChanged = lastChanged;
    return this;
  }

  public void unsetLastChanged() {
    this.lastChanged = null;
  }

  /** Returns true if field lastChanged is set (has been assigned a value) and false otherwise */
  public boolean isSetLastChanged() {
    return this.lastChanged != null;
  }

  public void setLastChangedIsSet(boolean value) {
    if (!value) {
      this.lastChanged = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SINA_AD_SPACE_ID:
      if (value == null) {
        unsetSinaAdSpaceId();
      } else {
        setSinaAdSpaceId((String)value);
      }
      break;

    case AD_SIZE:
      if (value == null) {
        unsetAdSize();
      } else {
        setAdSize((String)value);
      }
      break;

    case CATEGORY:
      if (value == null) {
        unsetCategory();
      } else {
        setCategory((String)value);
      }
      break;

    case SUB_CATEGORY:
      if (value == null) {
        unsetSubCategory();
      } else {
        setSubCategory((String)value);
      }
      break;

    case SOURCE:
      if (value == null) {
        unsetSource();
      } else {
        setSource((String)value);
      }
      break;

    case PAGE_URL:
      if (value == null) {
        unsetPageUrl();
      } else {
        setPageUrl((String)value);
      }
      break;

    case MEDIA_IDS:
      if (value == null) {
        unsetMediaIds();
      } else {
        setMediaIds((String)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    case LAST_CHANGED:
      if (value == null) {
        unsetLastChanged();
      } else {
        setLastChanged((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SINA_AD_SPACE_ID:
      return getSinaAdSpaceId();

    case AD_SIZE:
      return getAdSize();

    case CATEGORY:
      return getCategory();

    case SUB_CATEGORY:
      return getSubCategory();

    case SOURCE:
      return getSource();

    case PAGE_URL:
      return getPageUrl();

    case MEDIA_IDS:
      return getMediaIds();

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SINA_AD_SPACE_ID:
      return isSetSinaAdSpaceId();
    case AD_SIZE:
      return isSetAdSize();
    case CATEGORY:
      return isSetCategory();
    case SUB_CATEGORY:
      return isSetSubCategory();
    case SOURCE:
      return isSetSource();
    case PAGE_URL:
      return isSetPageUrl();
    case MEDIA_IDS:
      return isSetMediaIds();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Sina_Ad_Space)
      return this.equals((TDbSync_Dsp_Sina_Ad_Space)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Sina_Ad_Space that) {
    if (that == null)
      return false;

    boolean this_present_sinaAdSpaceId = true && this.isSetSinaAdSpaceId();
    boolean that_present_sinaAdSpaceId = true && that.isSetSinaAdSpaceId();
    if (this_present_sinaAdSpaceId || that_present_sinaAdSpaceId) {
      if (!(this_present_sinaAdSpaceId && that_present_sinaAdSpaceId))
        return false;
      if (!this.sinaAdSpaceId.equals(that.sinaAdSpaceId))
        return false;
    }

    boolean this_present_adSize = true && this.isSetAdSize();
    boolean that_present_adSize = true && that.isSetAdSize();
    if (this_present_adSize || that_present_adSize) {
      if (!(this_present_adSize && that_present_adSize))
        return false;
      if (!this.adSize.equals(that.adSize))
        return false;
    }

    boolean this_present_category = true && this.isSetCategory();
    boolean that_present_category = true && that.isSetCategory();
    if (this_present_category || that_present_category) {
      if (!(this_present_category && that_present_category))
        return false;
      if (!this.category.equals(that.category))
        return false;
    }

    boolean this_present_subCategory = true && this.isSetSubCategory();
    boolean that_present_subCategory = true && that.isSetSubCategory();
    if (this_present_subCategory || that_present_subCategory) {
      if (!(this_present_subCategory && that_present_subCategory))
        return false;
      if (!this.subCategory.equals(that.subCategory))
        return false;
    }

    boolean this_present_source = true && this.isSetSource();
    boolean that_present_source = true && that.isSetSource();
    if (this_present_source || that_present_source) {
      if (!(this_present_source && that_present_source))
        return false;
      if (!this.source.equals(that.source))
        return false;
    }

    boolean this_present_pageUrl = true && this.isSetPageUrl();
    boolean that_present_pageUrl = true && that.isSetPageUrl();
    if (this_present_pageUrl || that_present_pageUrl) {
      if (!(this_present_pageUrl && that_present_pageUrl))
        return false;
      if (!this.pageUrl.equals(that.pageUrl))
        return false;
    }

    boolean this_present_mediaIds = true && this.isSetMediaIds();
    boolean that_present_mediaIds = true && that.isSetMediaIds();
    if (this_present_mediaIds || that_present_mediaIds) {
      if (!(this_present_mediaIds && that_present_mediaIds))
        return false;
      if (!this.mediaIds.equals(that.mediaIds))
        return false;
    }

    boolean this_present_Status = true;
    boolean that_present_Status = true;
    if (this_present_Status || that_present_Status) {
      if (!(this_present_Status && that_present_Status))
        return false;
      if (this.Status != that.Status)
        return false;
    }

    boolean this_present_lastChanged = true && this.isSetLastChanged();
    boolean that_present_lastChanged = true && that.isSetLastChanged();
    if (this_present_lastChanged || that_present_lastChanged) {
      if (!(this_present_lastChanged && that_present_lastChanged))
        return false;
      if (!this.lastChanged.equals(that.lastChanged))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Sina_Ad_Space other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSinaAdSpaceId()).compareTo(other.isSetSinaAdSpaceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSinaAdSpaceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sinaAdSpaceId, other.sinaAdSpaceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAdSize()).compareTo(other.isSetAdSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAdSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.adSize, other.adSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCategory()).compareTo(other.isSetCategory());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCategory()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.category, other.category);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubCategory()).compareTo(other.isSetSubCategory());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubCategory()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subCategory, other.subCategory);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSource()).compareTo(other.isSetSource());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSource()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.source, other.source);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageUrl()).compareTo(other.isSetPageUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageUrl, other.pageUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMediaIds()).compareTo(other.isSetMediaIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMediaIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mediaIds, other.mediaIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Status, other.Status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastChanged()).compareTo(other.isSetLastChanged());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastChanged()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastChanged, other.lastChanged);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Sina_Ad_Space(");
    boolean first = true;

    sb.append("sinaAdSpaceId:");
    if (this.sinaAdSpaceId == null) {
      sb.append("null");
    } else {
      sb.append(this.sinaAdSpaceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("adSize:");
    if (this.adSize == null) {
      sb.append("null");
    } else {
      sb.append(this.adSize);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("category:");
    if (this.category == null) {
      sb.append("null");
    } else {
      sb.append(this.category);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("subCategory:");
    if (this.subCategory == null) {
      sb.append("null");
    } else {
      sb.append(this.subCategory);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("source:");
    if (this.source == null) {
      sb.append("null");
    } else {
      sb.append(this.source);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageUrl:");
    if (this.pageUrl == null) {
      sb.append("null");
    } else {
      sb.append(this.pageUrl);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mediaIds:");
    if (this.mediaIds == null) {
      sb.append("null");
    } else {
      sb.append(this.mediaIds);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Status:");
    sb.append(this.Status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastChanged:");
    if (this.lastChanged == null) {
      sb.append("null");
    } else {
      sb.append(this.lastChanged);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (sinaAdSpaceId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sinaAdSpaceId' was not present! Struct: " + toString());
    }
    if (adSize == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'adSize' was not present! Struct: " + toString());
    }
    if (category == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'category' was not present! Struct: " + toString());
    }
    if (subCategory == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'subCategory' was not present! Struct: " + toString());
    }
    if (source == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'source' was not present! Struct: " + toString());
    }
    if (pageUrl == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pageUrl' was not present! Struct: " + toString());
    }
    if (mediaIds == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mediaIds' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'Status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TDbSync_Dsp_Sina_Ad_SpaceStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Sina_Ad_SpaceStandardScheme getScheme() {
      return new TDbSync_Dsp_Sina_Ad_SpaceStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Sina_Ad_SpaceStandardScheme extends StandardScheme<TDbSync_Dsp_Sina_Ad_Space> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Sina_Ad_Space struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SINA_AD_SPACE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sinaAdSpaceId = iprot.readString();
              struct.setSinaAdSpaceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AD_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.adSize = iprot.readString();
              struct.setAdSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CATEGORY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.category = iprot.readString();
              struct.setCategoryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SUB_CATEGORY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.subCategory = iprot.readString();
              struct.setSubCategoryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SOURCE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.source = iprot.readString();
              struct.setSourceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PAGE_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.pageUrl = iprot.readString();
              struct.setPageUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // MEDIA_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mediaIds = iprot.readString();
              struct.setMediaIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'Status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Sina_Ad_Space struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sinaAdSpaceId != null) {
        oprot.writeFieldBegin(SINA_AD_SPACE_ID_FIELD_DESC);
        oprot.writeString(struct.sinaAdSpaceId);
        oprot.writeFieldEnd();
      }
      if (struct.adSize != null) {
        oprot.writeFieldBegin(AD_SIZE_FIELD_DESC);
        oprot.writeString(struct.adSize);
        oprot.writeFieldEnd();
      }
      if (struct.category != null) {
        oprot.writeFieldBegin(CATEGORY_FIELD_DESC);
        oprot.writeString(struct.category);
        oprot.writeFieldEnd();
      }
      if (struct.subCategory != null) {
        oprot.writeFieldBegin(SUB_CATEGORY_FIELD_DESC);
        oprot.writeString(struct.subCategory);
        oprot.writeFieldEnd();
      }
      if (struct.source != null) {
        oprot.writeFieldBegin(SOURCE_FIELD_DESC);
        oprot.writeString(struct.source);
        oprot.writeFieldEnd();
      }
      if (struct.pageUrl != null) {
        oprot.writeFieldBegin(PAGE_URL_FIELD_DESC);
        oprot.writeString(struct.pageUrl);
        oprot.writeFieldEnd();
      }
      if (struct.mediaIds != null) {
        oprot.writeFieldBegin(MEDIA_IDS_FIELD_DESC);
        oprot.writeString(struct.mediaIds);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.Status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Sina_Ad_SpaceTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Sina_Ad_SpaceTupleScheme getScheme() {
      return new TDbSync_Dsp_Sina_Ad_SpaceTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Sina_Ad_SpaceTupleScheme extends TupleScheme<TDbSync_Dsp_Sina_Ad_Space> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Sina_Ad_Space struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.sinaAdSpaceId);
      oprot.writeString(struct.adSize);
      oprot.writeString(struct.category);
      oprot.writeString(struct.subCategory);
      oprot.writeString(struct.source);
      oprot.writeString(struct.pageUrl);
      oprot.writeString(struct.mediaIds);
      oprot.writeI32(struct.Status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Sina_Ad_Space struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.sinaAdSpaceId = iprot.readString();
      struct.setSinaAdSpaceIdIsSet(true);
      struct.adSize = iprot.readString();
      struct.setAdSizeIsSet(true);
      struct.category = iprot.readString();
      struct.setCategoryIsSet(true);
      struct.subCategory = iprot.readString();
      struct.setSubCategoryIsSet(true);
      struct.source = iprot.readString();
      struct.setSourceIsSet(true);
      struct.pageUrl = iprot.readString();
      struct.setPageUrlIsSet(true);
      struct.mediaIds = iprot.readString();
      struct.setMediaIdsIsSet(true);
      struct.Status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}

