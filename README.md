# Cockblocker
Cockblocker was a Fabric mod intended to fix lag and crash exploits that affected the client. It supported 1.16.2 - 1.16.5 and was one of the first projects that I had made from scratch.

It was private for almost 2 years, mainly because it fixed an extremely powerful exploit for 1.16.5 that was actively being used on TotalFreedom for administrative purposes. At the time of the mod's creation, knowledge of how said exploit worked was rudimentary in the exploiting communities I was aware of, with many exploit figures beng forced to manually delete the skin files to avoid having their clients crash when encountering items with the exploit in them. Cockblocker's way of patching the exploit resolved the root cause of the issue and as such gave administrators an advantage over those attacking their server.

Development of this mod has since been discontinued, as most of my exploit-fixing work can be seen as a submodule for WNT.

## What did it patch?
Cockblocker patched a couple of client-side and occasionally some server-side exploits. Here's a list:
* Server-side crash exploit where dispensing fire upside-down caused server crashes (patched in 1.16.5)
* Server-side crash exploit with /setworldspawn and /spawnpoinit (both patched in 1.17+)
* Clickable text that ran commands (both server-side and client-side)
* Client-side crash exploit caused by skin textures with insufficient resolutions (patched in 1.17+)
* Client-side lag exploit caused by rendering too many hearts in the HUD
* Client-side lag exploit caused by rendering entities with ridiculously long names
