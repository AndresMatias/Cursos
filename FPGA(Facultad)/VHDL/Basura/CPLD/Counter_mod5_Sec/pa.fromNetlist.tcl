
# PlanAhead Launch Script for Post-Synthesis floorplanning, created by Project Navigator

create_project -name Counter_mod5_Sec -dir "C:/Users/facun/Desktop/Lab 5/Counter_mod5_Sec/planAhead_run_1" -part xc3s100etq144-4
set_property design_mode GateLvl [get_property srcset [current_run -impl]]
set_property edif_top_file "C:/Users/facun/Desktop/Lab 5/Counter_mod5_Sec/mod5_Up_Down_Sec.ngc" [ get_property srcset [ current_run ] ]
add_files -norecurse { {C:/Users/facun/Desktop/Lab 5/Counter_mod5_Sec} }
set_property target_constrs_file "mod5_Up_Down_Sec.ucf" [current_fileset -constrset]
add_files [list {mod5_Up_Down_Sec.ucf}] -fileset [get_property constrset [current_run]]
link_design
