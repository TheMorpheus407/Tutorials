if {[package vsatisfies 8.0 [package provide Tcl]]} { 
    set add 80
} else {
    set add {t}
}
if {[info exists ::tcl_platform(debug)] && $::tcl_platform(debug) && \
        [file exists [file join $dir itcl40${add}g.dll]]} {
    package ifneeded Itcl 4.0.0 [list load [file join $dir itcl40${add}g.dll] Itcl]
} else {
    package ifneeded Itcl 4.0.0 [list load [file join $dir itcl40${add}.dll] Itcl]
}
unset add
