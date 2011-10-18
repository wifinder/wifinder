// Automatically Generated -- DO NOT EDIT
// com.wifinder.shared.HotspotsRequestFactory
package com.wifinder.shared;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class HotspotsRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("NOnVQiMlPc1UDz7aJR6yqdEbV6I="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/wifinder/shared/HotspotProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/wifinder/server/Hotspot;)V")
  .withMethodName("deleteHotspot")
  .withRequestContext("com.wifinder.shared.CloudHotspotRequest")
  .build());
withOperation(new OperationKey("fLLfOzg7nOf8smJGDMEkCcha42Y="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("queryHotspots")
  .withRequestContext("com.wifinder.shared.CloudHotspotRequest")
  .build());
withOperation(new OperationKey("hkw75dE4YzYnBOnqMNyS1CdzfNk="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/wifinder/shared/HotspotProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/wifinder/server/Hotspot;)Lcom/wifinder/server/Hotspot;")
  .withMethodName("updateHotspot")
  .withRequestContext("com.wifinder.shared.CloudHotspotRequest")
  .build());
withOperation(new OperationKey("X5HLokTGf$De0YEfWho$wElDSJ8="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/Long;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/Long;)Lcom/wifinder/server/Hotspot;")
  .withMethodName("readHotspot")
  .withRequestContext("com.wifinder.shared.CloudHotspotRequest")
  .build());
withOperation(new OperationKey("iTCBUMm8GEP8rnIQS$AeshEZhyM="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Lcom/wifinder/server/Hotspot;")
  .withMethodName("createHotspot")
  .withRequestContext("com.wifinder.shared.CloudHotspotRequest")
  .build());
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("huoIKVScjB44ZTqI01gxERJc0rc=", "com.wifinder.shared.HotspotProxy");
withClientToDomainMappings("com.wifinder.server.Hotspot", Arrays.asList("com.wifinder.shared.HotspotProxy"));
}}
