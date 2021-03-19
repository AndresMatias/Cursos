
# PlanAhead Launch Script for Post-Synthesis floorplanning, created by Project Navigator

create_project -name Cont-0-9999 -dir "C:/Users/facun/Desktop/Lab 5/Cont-0-9999/planAhead_run_2" -part xc3s100etq144-4
set_property design_mode GateLvl [get_property srcset [current_run -impl]]
set_property edif_top_file "C:/Users/facun/Desktop/Lab 5/Cont-0-9999/Counter_Top.ngc" [ get_property srcset [ current_run ] ]
add_files -norecurse { {C:/Users/facun/Desktop/Lab 5/Cont-0-9999} }
set_property target_constrs_file "Counter_Top.ucf" [current_fileset -constrset]
add_files [list {Counter_Top.ucf}] -fileset [get_property constrset [current_run]]
link_design
