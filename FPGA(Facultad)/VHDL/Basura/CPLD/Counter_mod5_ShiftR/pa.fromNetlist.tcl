
# PlanAhead Launch Script for Post-Synthesis floorplanning, created by Project Navigator

create_project -name Counter_mod5_ShiftR -dir "C:/Users/facun/Desktop/Lab 5/Counter_mod5_ShiftR/planAhead_run_4" -part xc3s100etq144-4
set_property design_mode GateLvl [get_property srcset [current_run -impl]]
set_property edif_top_file "C:/Users/facun/Desktop/Lab 5/Counter_mod5_ShiftR/Mod5_LR_Up_Down.ngc" [ get_property srcset [ current_run ] ]
add_files -norecurse { {C:/Users/facun/Desktop/Lab 5/Counter_mod5_ShiftR} }
set_property target_constrs_file "Mod5_LR_Up_Down.ucf" [current_fileset -constrset]
add_files [list {Mod5_LR_Up_Down.ucf}] -fileset [get_property constrset [current_run]]
link_design
